
package hadleys.hope.minisims.test.utils;

import hadleys.hope.minisims.collisionsystem.Collidable;
import hadleys.hope.minisims.entitysystem.Entity;
import org.dyn4j.dynamics.Body;

public class TestCollidableEntity extends Entity implements Collidable {

    public TestCollidableEntity(String id) {
        super(id);
    }

    @Override
    public void update(double deltaTime) {
        
    }

    @Override
    public Body getCollisionBody() {
        return null;
    }
}
