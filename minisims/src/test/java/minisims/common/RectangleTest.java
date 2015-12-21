/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minisims.common;

import java.util.List;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {
    
    private Rectangle rectangle;
    
    @Before
    public void setUp() {
        final double[][] matrixDataA = { {-3.0, 0.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(matrixDataA);
        
        final double[][] matrixDataB = { {2.0, 5.0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(matrixDataB);
        
        final double[][] matrixDataC = { {5.0, 2.0} };
        final RealMatrix pointC = new Array2DRowRealMatrix(matrixDataC);
        
        final double[][] matrixDataD = { {0.0, -3.0} };
        final RealMatrix pointD = new Array2DRowRealMatrix(matrixDataD);
        
        this.rectangle = new Rectangle(pointA, pointB, pointC, pointD);
    }
    
    @Test
    public void shouldHaveCorrectStringPresentation() {
        assertEquals("A: Array2DRowRealMatrix{{-3.0,0.0}}\nB: Array2DRowRealMatrix{{2.0,5.0}}\nC: Array2DRowRealMatrix{{5.0,2.0}}\nD: Array2DRowRealMatrix{{0.0,-3.0}}",
                this.rectangle.toString());
    }
    
    @Test
    public void shouldSetLocationCorrectlyWithZeroOffset() {
        final double[][] newLocationMatrixDataA = { {-3.0, 0.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(newLocationMatrixDataA);
        
        final double[][] newLocationMatrixDataB = { {2.0, 5.0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(newLocationMatrixDataB);
        
        final double[][] newLocationMatrixDataC = { {5.0, 2.0} };
        final RealMatrix pointC = new Array2DRowRealMatrix(newLocationMatrixDataC);
        
        final double[][] newLocationMatrixDataD = { {0.0, -3.0} };
        final RealMatrix pointD = new Array2DRowRealMatrix(newLocationMatrixDataD);
        
        final Rectangle newLocation = new Rectangle(pointA, pointB, pointC, pointD);
        
        final double[][] newLocationMatrixData = { {-3.0, 0.0} };
        final RealMatrix point = new Array2DRowRealMatrix(newLocationMatrixData);
        this.rectangle.setLocation(point);
        
        assertEquals(this.rectangle, newLocation);
    }
    
    @Test
    public void shouldSetLocationCorrectlyToPositiveDirection() {
        final double[][] newLocationMatrixDataA = { {1.0, 6.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(newLocationMatrixDataA);
        
        final double[][] newLocationMatrixDataB = { {6.0, 11.0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(newLocationMatrixDataB);
        
        final double[][] newLocationMatrixDataC = { {9.0, 8.0} };
        final RealMatrix pointC = new Array2DRowRealMatrix(newLocationMatrixDataC);
        
        final double[][] newLocationMatrixDataD = { {4.0, 3.0} };
        final RealMatrix pointD = new Array2DRowRealMatrix(newLocationMatrixDataD);
        
        final Rectangle newLocation = new Rectangle(pointA, pointB, pointC, pointD);
        
        final double[][] newLocationMatrixData = { {1.0, 6.0} };
        final RealMatrix point = new Array2DRowRealMatrix(newLocationMatrixData);
        this.rectangle.setLocation(point);
        
        assertEquals(this.rectangle, newLocation);
    }
    
    @Test
    public void shouldSetLocationCorrectlyToNegativeDirection() {
        final double[][] newLocationMatrixDataA = { {-6.0, -8.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(newLocationMatrixDataA);
        
        final double[][] newLocationMatrixDataB = { {-1.0, -3.0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(newLocationMatrixDataB);
        
        final double[][] newLocationMatrixDataC = { {2.0, -6.0} };
        final RealMatrix pointC = new Array2DRowRealMatrix(newLocationMatrixDataC);
        
        final double[][] newLocationMatrixDataD = { {-3.0, -11.0} };
        final RealMatrix pointD = new Array2DRowRealMatrix(newLocationMatrixDataD);
        
        final Rectangle newLocation = new Rectangle(pointA, pointB, pointC, pointD);
        
        final double[][] newLocationMatrixData = { {-6.0, -8.0} };
        final RealMatrix point = new Array2DRowRealMatrix(newLocationMatrixData);
        this.rectangle.setLocation(point);
        
        assertEquals(this.rectangle, newLocation);
    }
    
    @Test
    public void shouldGlobalRotateCorrectlyWithZeroRotation() {
        final double[][] newLocationMatrixDataA = { {-3.0, 0.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(newLocationMatrixDataA);
        
        final double[][] newLocationMatrixDataB = { {2.0, 5.0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(newLocationMatrixDataB);
        
        final double[][] newLocationMatrixDataC = { {5.0, 2.0} };
        final RealMatrix pointC = new Array2DRowRealMatrix(newLocationMatrixDataC);
        
        final double[][] newLocationMatrixDataD = { {0.0, -3.0} };
        final RealMatrix pointD = new Array2DRowRealMatrix(newLocationMatrixDataD);
        
        final Rectangle newLocation = new Rectangle(pointA, pointB, pointC, pointD);
        
        final double[][] newLocationMatrixData = { {1.0, 6.0} };
        final RealMatrix point = new Array2DRowRealMatrix(newLocationMatrixData);
        this.rectangle.globalRotate(0);
        
        assertEquals(this.rectangle, newLocation);
    }
    
    
    @Test
    public void shouldGlobalRotateCorrectlyClockwise() {
        final double[][] newLocationMatrixDataA = { {0.0, 3.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(newLocationMatrixDataA);
        
        final double[][] newLocationMatrixDataB = { {5.0, -2.0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(newLocationMatrixDataB);
        
        final double[][] newLocationMatrixDataC = { {2.0, -5.0} };
        final RealMatrix pointC = new Array2DRowRealMatrix(newLocationMatrixDataC);
        
        final double[][] newLocationMatrixDataD = { {-3.0, 0.0} };
        final RealMatrix pointD = new Array2DRowRealMatrix(newLocationMatrixDataD);
        
        final Rectangle newLocation = new Rectangle(pointA, pointB, pointC, pointD);
        
        this.rectangle.globalRotate(Math.PI / 2);
        
        List<RealMatrix> rotatedRectanglePoints = this.rectangle.getPoints();
        List<RealMatrix> expectedRectanglePoints = newLocation.getPoints();
        for (int i = 0;i < rotatedRectanglePoints.size();i++) {
            double dataForRotatedPoint[][] = rotatedRectanglePoints.get(i).getData();
            double dataForExpectedPoint[][] = expectedRectanglePoints.get(i).getData();
            
            for (int j = 0;j < dataForRotatedPoint.length;j++) {
                
                for (int k = 0;k < dataForRotatedPoint[j].length;k++) {
                    
                    if (!(Math.abs(dataForRotatedPoint[j][k] - dataForExpectedPoint[j][k]) < 0.0001)) {
                        fail("was: " + this.rectangle.toString() + " expected: " + newLocation.toString());
                    }
                }
            }
        }
    }
    
    @Test
    public void shouldGlobalRotateCorrectlyCounterClockwise() {
        final double[][] newLocationMatrixDataA = { {0.0, -3.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(newLocationMatrixDataA);
        
        final double[][] newLocationMatrixDataB = { {-5.0, 2.0} };
        final RealMatrix pointB = new Array2DRowRealMatrix(newLocationMatrixDataB);
        
        final double[][] newLocationMatrixDataC = { {-2.0, 5.0} };
        final RealMatrix pointC = new Array2DRowRealMatrix(newLocationMatrixDataC);
        
        final double[][] newLocationMatrixDataD = { {3.0, 0.0} };
        final RealMatrix pointD = new Array2DRowRealMatrix(newLocationMatrixDataD);
        
        final Rectangle newLocation = new Rectangle(pointA, pointB, pointC, pointD);
        
        this.rectangle.globalRotate((-1) * Math.PI / 2);
        
        List<RealMatrix> rotatedRectanglePoints = this.rectangle.getPoints();
        List<RealMatrix> expectedRectanglePoints = newLocation.getPoints();
        for (int i = 0;i < rotatedRectanglePoints.size();i++) {
            double dataForRotatedPoint[][] = rotatedRectanglePoints.get(i).getData();
            double dataForExpectedPoint[][] = expectedRectanglePoints.get(i).getData();
            
            for (int j = 0;j < dataForRotatedPoint.length;j++) {
                
                for (int k = 0;k < dataForRotatedPoint[j].length;k++) {
                    
                    if (!(Math.abs(dataForRotatedPoint[j][k] - dataForExpectedPoint[j][k]) < 0.0001)) {
                        fail("was: " + this.rectangle.toString() + " expected: " + newLocation.toString());
                    }
                }
            }
        }
    }
}
