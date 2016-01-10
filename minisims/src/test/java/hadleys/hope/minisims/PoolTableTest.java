package hadleys.hope.minisims;

import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PoolTableTest {
    
    @Before
    public void initManagers() {
        EntityManager.startUp();
        RenderingManager.startUp();
    }
    
    @After
    public void shutdownManagers() {
        EntityManager.shutDown();
        RenderingManager.shutDown();
    }
    
    @Test
    public void shouldCreateWhiteBall() {
        PoolTable poolTable = new PoolTable("poolTable");
        assertTrue(poolTable.getWhiteBall() != null);
    }
    
    @Test
    public void shouldCreateColourBalls() {
        PoolTable poolTable = new PoolTable("poolTable");
        assertTrue(poolTable.getAllColourBalls().size() == 6);
    }
    
    @Test
    public void shouldCreateWalls() {
        PoolTable poolTable = new PoolTable("poolTable");
        
        int walls = 0;
        for (Entity entity : EntityManager.get().getAllEntities()) {
            
            if (entity.getId().contains("Wall")) {
                walls++;
            }
        }
        
        assertTrue(walls == 6);
    }
    
    @Test
    public void shouldCreateTableSurface() {
        PoolTable poolTable = new PoolTable("poolTable");
        
        boolean containsPoolTableSurface = false;
        for (Entity entity : EntityManager.get().getAllEntities()) {
            
            if (entity.getId().equals("tableSurface")) {
                containsPoolTableSurface = true;
            }
        }
        
        assertTrue(containsPoolTableSurface);
    }
    
    @Test
    public void shouldCreatePockets() {
        PoolTable poolTable = new PoolTable("poolTable");
        
        int pockets = 0;
        for (Entity entity : EntityManager.get().getAllEntities()) {
            
            if (entity.getId().contains("Wall")) {
                pockets++;
            }
        }
        
        assertTrue(pockets == 6);
    }
    
    @Test
    public void sholdRemoveAllWithClear() {
        PoolTable poolTable = new PoolTable("poolTable");
        
        poolTable.clear();
        
        assertTrue(EntityManager.get().getAllEntities().size() == 1);
        assertTrue(EntityManager.get().getAllEntities().contains(poolTable));
    }
}
