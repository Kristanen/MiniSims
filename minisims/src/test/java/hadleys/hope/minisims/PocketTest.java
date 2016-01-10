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

public class PocketTest {
    
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
    public void shouldCorrectlyDetectWhenBallIsNotInPocket() {
        final double[][] pocketMatrixData = { {0.0, 0.0} };
        final RealMatrix pocketCenter = new Array2DRowRealMatrix(pocketMatrixData);
        
        Pocket pocket = new Pocket("pocket", new Circle(pocketCenter, 1.0), Color.BLACK);
        
        final double[][] ballMatrixData = { {2.0, 2.0} };
        final RealMatrix ballCenter = new Array2DRowRealMatrix(ballMatrixData);
        
        Ball ball = new Ball("ball_test_shouldCorrectlyDetectWhenBallIsNotInPocket", new Circle(ballCenter, 0.5), Color.WHITE, Color.BLACK);
    
        assertTrue(!pocket.isBallInPocket(ball));
    }
    
    @Test
    public void shouldCorrectlyDetectWhenBallIsInPocket() {
        final double[][] pocketMatrixData = { {0.0, 0.0} };
        final RealMatrix pocketCenter = new Array2DRowRealMatrix(pocketMatrixData);
        
        Pocket pocket = new Pocket("pocket", new Circle(pocketCenter, 0.6), Color.BLACK);
        
        final double[][] ballMatrixData = { {0.0, 0.0} };
        final RealMatrix ballCenter = new Array2DRowRealMatrix(ballMatrixData);
        
        Ball ball = new Ball("ball_test_shouldCorrectlyDetectWhenBallIsInPocket", new Circle(ballCenter, 0.5), Color.WHITE, Color.BLACK);
    
        assertTrue(pocket.isBallInPocket(ball));
    }
    
    @Test
    public void shouldCorrectleDetectBallIsNotInPocketWhenPartiallyInPocket() {
        final double[][] pocketMatrixData = { {0.0, 0.0} };
        final RealMatrix pocketCenter = new Array2DRowRealMatrix(pocketMatrixData);
        
        Pocket pocket = new Pocket("pocket", new Circle(pocketCenter, 1.0), Color.BLACK);
        
        final double[][] ballMatrixData = { {1.0, 0.0} };
        final RealMatrix ballCenter = new Array2DRowRealMatrix(ballMatrixData);
        
        Ball ball = new Ball("ball_test_shouldCorrectleDetectBallIsNotInPocketWhenPartiallyInPocket", new Circle(ballCenter, 0.5), Color.WHITE, Color.BLACK);
    
        assertTrue(!pocket.isBallInPocket(ball));
    }
    
    @Test
    public void shouldHaveRenderingLevelOne() {
        final double[][] pocketMatrixData = { {1.0, 1.0} };
        final RealMatrix pocketCenter = new Array2DRowRealMatrix(pocketMatrixData);
        
        Pocket pocket = new Pocket("pocket", new Circle(pocketCenter, 0.06), Color.BLACK);
        
        assertTrue(pocket.getRenderingLevel() == 1);
    }
}
