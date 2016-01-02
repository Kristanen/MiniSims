package hadleys.hope.minisims.collisionsystem;

import org.dyn4j.dynamics.Body;

/**
 * All entities which are collidable implements this.
 * @author Krista Iltanen
 */
public interface Collidable {
    
    Body getCollisionBody();
}
