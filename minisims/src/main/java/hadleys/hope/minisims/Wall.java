package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.Collidable;
import hadleys.hope.minisims.common.Rectangle;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.renderingsystem.Renderable;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import java.awt.Graphics2D;
import java.awt.Paint;
import org.apache.commons.math3.linear.RealMatrix;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;

/**
 * Presents a single wall of the pool table.
 * @author Krista Iltanen
 */
public class Wall extends Entity implements Renderable, Collidable {
    
    private Paint fill;
    private Paint edge;
    
    private Body collisionBody;
    private Rectangle wireframe;
    
    public Wall(String id, Rectangle wireframe, Paint fill, Paint edge) {
        super(id);
        
        this.fill = fill;
        this.edge = edge;
        
        this.wireframe = wireframe;
        
        this.collisionBody = new Body();
        this.collisionBody.addFixture(new org.dyn4j.geometry.Rectangle(this.wireframe.getWidth(), this.wireframe.getHeight()));
        this.collisionBody.setMass(MassType.INFINITE);
        
        RealMatrix upperLeftCorner = this.wireframe.getPoints().get(0);
        this.collisionBody.translate(upperLeftCorner.getEntry(0, 0) + (1.0/2.0) * this.wireframe.getWidth() , upperLeftCorner.getEntry(0, 1) + (1.0/2.0) * this.wireframe.getHeight());
    }

    @Override
    public void update(double deltaTime) {
        // Does nothing
    }

    @Override
    public void render(Graphics2D graphics2D) {
        RealMatrix upperLeftCorner = this.wireframe.getPoints().get(0);
        
        int width = (int)(this.wireframe.getWidth() / RenderingManager.SCALE_IN_METERS);
        int height = (int)(this.wireframe.getHeight() / RenderingManager.SCALE_IN_METERS);
        
        graphics2D.setPaint(this.fill);
        
        graphics2D.fillRect((int)(upperLeftCorner.getEntry(0, 0) / RenderingManager.SCALE_IN_METERS),
                (int)(upperLeftCorner.getEntry(0, 1) / RenderingManager.SCALE_IN_METERS),
                width, height);
        
        graphics2D.setPaint(this.edge);
        
        graphics2D.drawRect((int)(upperLeftCorner.getEntry(0, 0) / RenderingManager.SCALE_IN_METERS),
                (int)(upperLeftCorner.getEntry(0, 1) / RenderingManager.SCALE_IN_METERS),
                width, height);
    }

    @Override
    public Body getCollisionBody() {
        return this.collisionBody;
    }

    @Override
    public int getRenderingLevel() {
        return 2;
    }
}
