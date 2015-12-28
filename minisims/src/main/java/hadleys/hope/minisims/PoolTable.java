package hadleys.hope.minisims;

import java.awt.Color;
import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class PoolTable {
    private Ball whiteBall;
    
    public PoolTable() {
        final double[][] matrixDataA = { {400.0, 400.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(matrixDataA);
        
        this.whiteBall = new Ball("whiteBall", new Circle(pointA, 50), Color.WHITE, Color.BLACK);
        
        this.registerObjectsToEnityManager();
        this.registerObjectsToRenderManager();
    }
    
    private void registerObjectsToEnityManager() {
        EntityManager.get().addEntity(this.whiteBall);
    }
    
    private void registerObjectsToRenderManager() {
        RenderingManager.get().addRenderableObject(this.whiteBall);
    }
}
