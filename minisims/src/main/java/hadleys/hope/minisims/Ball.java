package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.Collidable;
import hadleys.hope.minisims.collisionsystem.CollisionManager;
import java.awt.Graphics2D;
import java.awt.Paint;
import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.renderingsystem.Renderable;
import org.apache.commons.math3.linear.RealMatrix;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Mass;
import org.dyn4j.geometry.Vector2;

/**
 * Presents a single ball on the table.
 * @author Krista Iltanen
 */
public class Ball extends Entity implements Renderable, Collidable {
    
    private Paint fill;
    private Paint edge;
    private Circle wireframe;
    public Body collisionBody;
    
    /**
     * Constructor for ball.
     * 
     * @param id Unique identifier for the ball.
     * @param wireframe Circle representing boundaries of the ball.
     * @param fill Colour which is used to paint the interior of the ball.
     * @param edge Colour which is used to paint the edges of the ball.
     */
    public Ball(String id, Circle wireframe, Paint fill, Paint edge) {
        super(id);
        this.wireframe = wireframe;
        this.fill = fill;
        this.edge = edge;
        
        this.collisionBody = new Body();
        this.collisionBody.addFixture(new org.dyn4j.geometry.Circle(this.wireframe.getRay()));
        this.collisionBody.translate(this.wireframe.getCenter().getEntry(0, 0), this.wireframe.getCenter().getEntry(0, 1));
        this.collisionBody.setMass(new Mass(new Vector2(this.wireframe.getCenter().getEntry(0, 0), this.wireframe.getCenter().getEntry(0, 1)),
                                        0.2, 100.0));
    }

    /**
     * Renders the ball.
     * 
     * @param graphics2D Graphics objects which is used for drawing.
     */
    @Override
    public void render(Graphics2D graphics2D) {
        int diameter = (int) (this.wireframe.getRay() * 2.0);
        int leftCornerX = (int)(this.wireframe.getCenter().getEntry(0, 0) - this.wireframe.getRay());
        int leftCornerY = (int)(this.wireframe.getCenter().getEntry(0, 1) - this.wireframe.getRay());
        
        graphics2D.setPaint(this.fill);
        graphics2D.fillOval(leftCornerX, leftCornerY, diameter, diameter);
        
        graphics2D.setPaint(this.edge);
        graphics2D.drawOval(leftCornerX, leftCornerY, diameter, diameter);
    }   

    /**
     * Update ball logic.
     * 
     * @param deltaTime Time passed since last frame.
     */
    @Override
    public void update(double deltaTime) {
        this.collisionBody = CollisionManager.get().getWorldBody(this);
        
        this.collisionBody.applyForce(new Vector2(1, 1));
        
        RealMatrix center = this.wireframe.getCenter();
        center.setEntry(0, 0, this.collisionBody.getTransform().getTranslationX() * 2);
        center.setEntry(0, 0, this.collisionBody.getTransform().getTranslationY() * 2);
        this.wireframe.setCenter(center);
    }

    /**
     * Return collision body object.
     * 
     * @return 
     */
    @Override
    public Body getCollisionBody() {
        return this.collisionBody;
    }
}
