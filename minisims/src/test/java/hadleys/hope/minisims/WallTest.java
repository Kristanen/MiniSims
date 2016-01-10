package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.CollisionManager;
import hadleys.hope.minisims.common.Rectangle;
import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import java.awt.Color;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class WallTest {
    
    @Before
    public void init() {
        EntityManager.startUp();
        CollisionManager.startUp();
        RenderingManager.startUp();
    }
    
    @After
    public void cleanUp() {
        EntityManager.shutDown();
        CollisionManager.shutDown();
        RenderingManager.shutDown();
    }
    
    @Test
    public void shouldHaveRenderingLevelTwo() {
        final double[][] pointAMatrixData = { {0, 0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(pointAMatrixData);
        
        final double[][] pointBMatrixData = { {1, 0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(pointBMatrixData);
        
        final double[][] pointCMatrixData = { {0, 1} };
        final RealMatrix pointC = new Array2DRowRealMatrix(pointCMatrixData);
        
        final double[][] pointDMatrixData = { {1, 1} };
        final RealMatrix pointD = new Array2DRowRealMatrix(pointDMatrixData);
        
        Wall wall = new Wall("wall", new Rectangle(pointA, pointB, pointC, pointD), new Color(117, 73, 25), Color.BLACK);
        
        assertTrue(wall.getRenderingLevel() == 2);
    }
}
