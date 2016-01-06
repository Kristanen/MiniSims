package hadleys.hope.minisims;

import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

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
}
