package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.Collidable;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.renderingsystem.Renderable;
import java.awt.Graphics2D;
import org.dyn4j.dynamics.Body;

/**
 * Presents a single wall of the pool table.
 * @author Krista Iltanen
 */
public class Wall extends Entity implements Renderable, Collidable {

    public Wall(String id) {
        super(id);
    }

    @Override
    public void update(double deltaTime) {
        // Does nothing
    }

    @Override
    public void render(Graphics2D graphics2D) {
        
    }

    @Override
    public Body getCollisionBody() {
        return null;
    }
}
