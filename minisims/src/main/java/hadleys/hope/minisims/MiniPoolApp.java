package hadleys.hope.minisims;

import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;

public class MiniPoolApp {
    
    public static void main(String[] argv) {
        EntityManager.startUp();
        RenderingManager.startUp();
        
        PoolTable poolTable = new PoolTable();
        
        RenderingManager.get().createWindow();
        
        RenderingManager.shutDown();
        EntityManager.shutDown();
    }
}
