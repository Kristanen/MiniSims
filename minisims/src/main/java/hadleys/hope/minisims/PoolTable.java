package hadleys.hope.minisims;

import java.awt.Color;
import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.entitysystem.EntityManager;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Presents all aspects of the pool table.
 * @author Krista Iltanen
 */
public class PoolTable {
    private Ball whiteBall;
    
    public PoolTable() {
        final double[][] matrixDataA = { {400.0, 400.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(matrixDataA);
        
        this.whiteBall = new Ball("whiteBall", new Circle(pointA, 14.3), Color.WHITE, Color.BLACK);
        
        this.registerObjectsToEnityManager();
    }
    
    private void registerObjectsToEnityManager() {
        EntityManager.get().addEntity(this.whiteBall);
    }
}
