package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.CollisionManager;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PoolGameTest {
    
    @Before
    public void init() {
        EntityManager.startUp();
        CollisionManager.startUp();
        RenderingManager.startUp();
    }
    
    @After
    public void cleanUp() {
        PoolGame.shutdow();
    }
    
    @Test
    public void shouldCreatePoolTable() {
        PoolGame.startUp();
        
        boolean containsPoolTable = false;
        for (Entity entity : EntityManager.get().getAllEntities()) {
            
            if (entity.getId().equals("poolTable")) {
                containsPoolTable = true;
            }
        }
        
        assertTrue(containsPoolTable);
    }
    
    @Test
    public void shuoldBeAbleToIncreaseHits() {
        PoolGame.startUp();
        
        assertTrue(PoolGame.get().getHits() == 0);
        
        PoolGame.get().hitPerformed();
        
        assertTrue(PoolGame.get().getHits() == 1);
    }
}
