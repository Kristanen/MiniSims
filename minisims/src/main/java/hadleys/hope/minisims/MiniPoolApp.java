package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.CollisionManager;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program starting point contains game loop, initialization and shut down.
 * @author Krista Iltanen
 */
public class MiniPoolApp {
    
    private static boolean isGameOver;
    
    /**
     * Main-method for the game. Initializes the game, calls for game loop and shuts the Managers down.
     * 
     * @param argv 
     */
    public static void main(String[] argv) {
        List<Manager> managers = new ArrayList<Manager>();
        
        EntityManager.startUp();
        RenderingManager.startUp();
        CollisionManager.startUp();
        PoolGame.startUp();
        
        managers.addAll(Arrays.asList(EntityManager.get(), RenderingManager.get(), CollisionManager.get(), PoolGame.get()));
        
        RenderingManager.get().createWindow();
        
        gameLoop(managers);
        
        PoolGame.shutdow();
        CollisionManager.shutDown();
        RenderingManager.shutDown();
        EntityManager.shutDown();
    }
    
    /**
     * Ends the game.
     */
    public static void endGame() {
        isGameOver = true;
    }
    
    /**
     * Represents one round of the game.
     * 
     * @param managers List of the Managers.
     */
    private static void gameLoop(List<Manager> managers) {
        isGameOver = false;
        
        double deltaTime = 1.0;
        
        while (!isGameOver) {
            long timeStart = System.currentTimeMillis();
            
            // Update logic
            for (Manager manager : managers) {
                manager.update(deltaTime);
            }
            
            for (Entity entity : EntityManager.get().getAllEntities()) {
                entity.update(deltaTime);
            }
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                // Do nothing sleep failed
            }
            
            deltaTime = (double)(System.currentTimeMillis() - timeStart) / 1000.0;
        }
    }
}
