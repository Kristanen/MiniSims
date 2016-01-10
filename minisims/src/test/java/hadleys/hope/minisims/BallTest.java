package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.CollisionManager;
import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import java.awt.Color;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class BallTest {
    
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
    public void shouldHaveCorrectCenter() {
        final double[][] matrixData = { {0.2, 0.4} };
        final RealMatrix center = new Array2DRowRealMatrix(matrixData);
        
        Ball ball = new Ball("ball", new Circle(center, 0.029), Color.WHITE, Color.BLACK);
        
        assertTrue(Math.abs(ball.getCenter().getEntry(0, 0) - center.getEntry(0, 0)) < 0.000001);
        assertTrue(Math.abs(ball.getCenter().getEntry(0, 1) - center.getEntry(0, 1)) < 0.000001);
    }
    
    @Test
    public void shouldHaveCorrectRay() {
        final double[][] matrixData = { {0.2, 0.4} };
        final RealMatrix center = new Array2DRowRealMatrix(matrixData);
        
        Ball ball = new Ball("ball", new Circle(center, 0.029), Color.WHITE, Color.BLACK);
        
        assertTrue(Math.abs(ball.getRay() - 0.029) < 0.000001);
    }
    
    @Test
    public void shouldHaveRenderingLevelThree() {
        final double[][] matrixData = { {0.2, 0.4} };
        final RealMatrix center = new Array2DRowRealMatrix(matrixData);
        
        Ball ball = new Ball("ball", new Circle(center, 0.029), Color.WHITE, Color.BLACK);
        
        assertTrue(ball.getRenderingLevel() == 3);
    }
}
