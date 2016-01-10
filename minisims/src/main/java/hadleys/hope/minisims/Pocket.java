package hadleys.hope.minisims;

import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.Renderable;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import java.awt.Graphics2D;
import java.awt.Paint;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;


/**
 * Represents the pockets in the game.
 * @author Krista Iltanen
 */
public class Pocket extends Entity implements Renderable {
    
    private Circle wireframe;
    private Paint fill;
    
    /**
     * Constructor for pocket.
     * @param id Unique identifier for the pocket.
     * @param wireframe Circle representing boundaries of the pocket.
     * @param fill Colour which is used to paint the interior of the pocket.
     */
    public Pocket(String id, Circle wireframe, Paint fill) {
        super(id);
        this.wireframe = wireframe;
        this.fill = fill;
    }

    @Override
    public void update(double deltaTime) {
        
        for (String ballId : PoolGame.get().getPoolTable().getAllColourBalls()) {
            Ball ball = (Ball)EntityManager.get().getEntity(ballId);
            
            if (ball != null && this.isBallInPocket(ball)) {
                EntityManager.get().removeEntity(ball.getId());
            }
        }
        
        Ball whiteBall = (Ball)EntityManager.get().getEntity(PoolGame.get().getPoolTable().getWhiteBall());
        if (this.isBallInPocket(whiteBall)) {
            final double[][] whiteBallMatrixData = { {0.4, 0.6} };
            final RealMatrix whiteBallCenter = new Array2DRowRealMatrix(whiteBallMatrixData);
            whiteBall.setCenter(whiteBallCenter);
            
            // Penalty
            for (int i = 0;i < 2;i ++) {
                PoolGame.get().hitPerformed();
            }
        }
    }

    @Override
    public int getRenderingLevel() {
        return 1;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        int diameter = (int) (this.wireframe.getRay() * 2.0 / RenderingManager.SCALE_IN_METERS);
        int leftCornerX = (int)((this.wireframe.getCenter().getEntry(0, 0) - this.wireframe.getRay()) / RenderingManager.SCALE_IN_METERS);
        int leftCornerY = (int)((this.wireframe.getCenter().getEntry(0, 1) - this.wireframe.getRay()) / RenderingManager.SCALE_IN_METERS);
        
        graphics2D.setPaint(this.fill);
        graphics2D.fillOval(leftCornerX, leftCornerY, diameter, diameter);
    }
    
    /**
     * Checks if the ball is in the pocket.
     * 
     * @param ball The ball whose situation is being examined.
     * @return True if ball is in the pocket and false if it is not.
     */
    public boolean isBallInPocket(Ball ball) {
        return this.wireframe.getCenter().subtract(ball.getCenter()).getNorm() <= Math.abs(this.wireframe.getRay() - ball.getRay());
    }
}
