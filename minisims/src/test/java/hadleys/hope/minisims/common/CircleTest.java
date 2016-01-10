package hadleys.hope.minisims.common;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CircleTest {
    
    @Test
    public void shouldHaveCorrectRay() {
        final double[][] matrixData = { {0.4, 0.6} };
        final RealMatrix center = new Array2DRowRealMatrix(matrixData);
        
        Circle circle = new Circle(center, 1.0);
        
        assertTrue(Math.abs(circle.getRay() - 1.0) < 0.0000001);
    }
    
    @Test
    public void shouldHaveCorrectCenter() {
        final double[][] matrixData = { {0.4, 0.6} };
        final RealMatrix center = new Array2DRowRealMatrix(matrixData);
        
        Circle circle = new Circle(center, 1.0);
        
        assertTrue(Math.abs(circle.getCenter().getEntry(0, 0) - 0.4) < 0.0000001);
        assertTrue(Math.abs(circle.getCenter().getEntry(0, 1) - 0.6) < 0.0000001);
    }
}
