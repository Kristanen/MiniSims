package hadleys.hope.minisims.enitysystem;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hadleys.hope.minisims.entitysystem.EntityManager;
import static org.junit.Assert.fail;

public class EntityManagerTest {
    
    // Uncomment when solution for Pit is found
    /*@Test
    public void shouldThrowExceptionWhenGetIsCalledBeforeStartUp() {
        try {
            EntityManager.get();
            fail();
        } catch (IllegalStateException e) {
            // Do nothing. Exception was thrown correctly.
        }
    }*/
    
    @Test
    public void shouldBeAbleToGetAfterStartUpIsCalled() {
        EntityManager.startUp();
        assertTrue(EntityManager.get() != null);
    }
}
