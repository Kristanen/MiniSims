package hadleys.hope.minisims.collisionsystem;

import hadleys.hope.minisims.Manager;
import hadleys.hope.minisims.entitysystem.EntityManager;
import java.util.HashSet;
import java.util.Set;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.Settings;
import org.dyn4j.dynamics.World;

/**
 * Manages collisions. In order to do this uses dyn4j-library.
 * @author Krista Iltanen
 */
public class CollisionManager implements Manager {
    private static CollisionManager collisionManager;
    
    private static final double MILLISECOND_BASE = 1000.0;
    
    private static boolean firstLoop = true;
    
    public static void startUp() {
        collisionManager = new CollisionManager();
    }
    
    public static void shutDown() {
        collisionManager = null;
    }
    
    public static CollisionManager get() {
        
        if (collisionManager == null) {
            throw new IllegalStateException("Collision Manager has not been initialized.");
        }
        
        return collisionManager;
    }
    
    private World world;
    
    private CollisionManager() {
        this.world = new World();
        
        Settings settings = this.world.getSettings();
        settings.setRestitutionVelocity(0);
        this.world.setSettings(settings);
        
        this.world.setGravity(new Vector2(0 ,0));
    }
    
    public Body getWorldBody(Collidable collidable) {
        for (Body worldBody : this.world.getBodies()) {
            
            if (worldBody.equals(collidable.getCollisionBody())) {
                
                if (firstLoop) {
                    firstLoop = false;
                    
                    worldBody.applyForce(new Vector2(50000, 10000));
                }
                
                return worldBody;
            }
        }
        
        return null;
    }
    
    @Override
    public void update(double deltaTime) {
        Set<Body> bodiesOfCollidables = new HashSet<Body>();
        
        // Add all bodies which have been added after previous update
        for (Collidable collidable : EntityManager.get().getCollidableObjects()) {
            Body body = collidable.getCollisionBody();
            
            bodiesOfCollidables.add(body);
            
            if (!this.world.getBodies().contains(body)) {
                this.world.addBody(body);
            }
        }
        
        // Remove all bodies which have been removed after previous update
        /*for (Body body : this.world.getBodies()) {
            
            if (!bodiesOfCollidables.contains(body)) {
                this.world.removeBody(body);
            }
        }*/
        
        this.world.updatev(deltaTime / MILLISECOND_BASE);
    }
}
