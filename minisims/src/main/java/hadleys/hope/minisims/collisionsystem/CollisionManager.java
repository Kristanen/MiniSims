package hadleys.hope.minisims.collisionsystem;

public class CollisionManager {
    private static CollisionManager collisionManager;
    
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
}
