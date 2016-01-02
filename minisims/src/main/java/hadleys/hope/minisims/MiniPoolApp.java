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
    
    public static void main(String[] argv) {
        List<Manager> managers = new ArrayList<Manager>();
        
        EntityManager.startUp();
        RenderingManager.startUp();
        CollisionManager.startUp();
        
        managers.addAll(Arrays.asList(EntityManager.get(), RenderingManager.get(), CollisionManager.get()));
        
        RenderingManager.get().createWindow();
        
        PoolTable poolTable = new PoolTable();
        
        gameLoop(poolTable, managers);
        
        CollisionManager.shutDown();
        RenderingManager.shutDown();
        EntityManager.shutDown();
    }
    
    public static void endGame() {
        isGameOver = true;
    }
    
    private static void gameLoop(PoolTable poolTable, List<Manager> managers) {
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
            
            deltaTime = (double)(System.currentTimeMillis() - timeStart) / 1000.0;
        }
    }
}
