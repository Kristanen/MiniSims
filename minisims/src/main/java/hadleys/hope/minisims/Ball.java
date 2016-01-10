package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.Collidable;
import hadleys.hope.minisims.collisionsystem.CollisionManager;
import java.awt.Graphics2D;
import java.awt.Paint;
import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.renderingsystem.Renderable;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import org.apache.commons.math3.linear.RealMatrix;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Transform;
import org.dyn4j.geometry.Vector2;

/**
 * Presents a single ball on the table.
 * @author Krista Iltanen
 */
public class Ball extends Entity implements Renderable, Collidable {
    
    private Paint fill;
    private Paint edge;
    private Circle wireframe;
    private Body collisionBody;
    
    private Vector2 forceToApply;
    
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
        this.collisionBody.setMass(MassType.NORMAL);
        this.collisionBody.setLinearDamping(300);
        
        this.forceToApply = null;
    }
    
    /**
     * Checks is the ball moving or not.
     * 
     * @return True if the ball isn't moving and false if it is.
     */
    public boolean isStill() {
        Body body = CollisionManager.get().getWorldBody(this);
        
        if (body == null) {
            return true;
        }
        
        Vector2 velocity = body.getLinearVelocity();
        boolean isStill = (Math.abs(velocity.x) < 3.0) && (Math.abs(velocity.y) < 3.0);
        
        if (isStill) {
            body.setLinearVelocity(0, 0);
        }
        
        return isStill;
    }
    
    /**
     * Hits the ball with desired force.
     * 
     * @param force The force used to hit the ball.
     */
    public void hit(Vector2 force) {
        
        PoolGame.get().hitPerformed();
        
        if (this.forceToApply == null) {
            this.forceToApply = force;
            return;
        }
        
        this.forceToApply = this.forceToApply.add(force);
    }
    
    /**
     * Renders the ball.
     * 
     * @param graphics2D Graphics objects which is used for drawing.
     */
    @Override
    public void render(Graphics2D graphics2D) {
        int diameter = (int) (this.wireframe.getRay() * 2.0 / RenderingManager.SCALE_IN_METERS);
        int leftCornerX = (int)((this.wireframe.getCenter().getEntry(0, 0) - this.wireframe.getRay()) / RenderingManager.SCALE_IN_METERS);
        int leftCornerY = (int)((this.wireframe.getCenter().getEntry(0, 1) - this.wireframe.getRay()) / RenderingManager.SCALE_IN_METERS);
        
        graphics2D.setPaint(this.fill);
        graphics2D.fillOval(leftCornerX, leftCornerY, diameter, diameter);
        
        graphics2D.setPaint(this.edge);
        graphics2D.drawOval(leftCornerX, leftCornerY, diameter, diameter);
    }   

    /**
     * Updates the ball logic.
     * 
     * @param deltaTime Time passed since last frame.
     */
    @Override
    public void update(double deltaTime) {
        this.collisionBody = CollisionManager.get().getWorldBody(this);
        
        // Apply force if needed
        if (this.forceToApply != null) {
            this.collisionBody.applyForce(this.forceToApply);
            this.forceToApply = null;
        }
        
        RealMatrix center = this.wireframe.getCenter();
        center.setEntry(0, 0, this.collisionBody.getTransform().getTranslationX());
        center.setEntry(0, 1, this.collisionBody.getTransform().getTranslationY());
        this.wireframe.setCenter(center);
    }

    /**
     * Returns collision body object.
     * 
     * @return Body
     */
    @Override
    public Body getCollisionBody() {
        return this.collisionBody;
    }

    @Override
    public int getRenderingLevel() {
        return 3;
    }
    
    /**
     * Returns center of the ball.
     * 
     * @return Center of the ball.
     */
    public RealMatrix getCenter() {
        return this.wireframe.getCenter();
    }
    
    /**
     * Sets center for the ball.
     * 
     * @param center Desired center for the ball.
     */
    public void setCenter(RealMatrix center) {
        this.wireframe.setCenter(center);
        
        Body body = CollisionManager.get().getWorldBody(this);
        
        if (body != null) {
            body.setLinearVelocity(0, 0);
            Transform transform = new Transform();
            transform.setTranslation(this.wireframe.getCenter().getEntry(0, 0), this.wireframe.getCenter().getEntry(0, 1));
            body.setTransform(transform);
        }
    }
    
    /**
     * Return ray of the ball.
     * 
     * @return 
     */
    public double getRay() {
        return this.wireframe.getRay();
    }
}
