package hadleys.hope.minisims;

import java.awt.Color;
import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.common.Rectangle;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.entitysystem.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Represents all aspects of the pool table.
 * @author Krista Iltanen
 */
public class PoolTable extends Entity {
    private String whiteBall;
    private List<String> otherBalls;
    
    private String tableSurface;
    
    private List<String> walls;
    private List<String> pockets;
    
    /**
     * Constructor for the pool table.
     * 
     * @param id Unique identifier for the table.
     */
    public PoolTable(String id) {
        super(id);
        
        this.createWhiteBall();
        this.createOtherBalls();
        this.createTableSurface();
        this.createWalls();
        this.createPockets();
    }

    @Override
    public void update(double deltaTime) {
        
    }
    
    public void clear() {
        
        for (String ballId : this.otherBalls) {
            EntityManager.get().removeEntity(ballId);
        }
        
        EntityManager.get().removeEntity(this.whiteBall);
        
        EntityManager.get().removeEntity(this.tableSurface);
        
        for (String wallId : this.walls) {
            EntityManager.get().removeEntity(wallId);
        }
        
        for (String pocketId : this.pockets) {
            EntityManager.get().removeEntity(pocketId);
        }
    }
    
    /**
     * Returns the white ball id.
     * 
     * @return white ball id
     */
    public String getWhiteBall() {
        return this.whiteBall;
    }
    
    /**
     * Returns all the coloured balls as a list.
     * @return 
     */
    public List<String> getAllColourBalls() {
        return this.otherBalls;
    }
    
    /**
     * Creates a white ball.
     */
    private void createWhiteBall() {
        final double[][] whiteBallMatrixData = { {0.4, 0.6} };
        final RealMatrix whiteBallCenter = new Array2DRowRealMatrix(whiteBallMatrixData);
        
        this.whiteBall = new Ball("whiteBall", new Circle(whiteBallCenter, 0.029), Color.WHITE, Color.BLACK).getId();
    }
    
    /**
     * Creates the coloured balls.
     */
    private void createOtherBalls() {
        this.otherBalls = new ArrayList<String>();
        
        Color colors[] = {new Color(110, 232, 77), new Color(247, 62, 161), new Color(55, 88, 237), new Color(252, 249, 73), Color.CYAN, new Color(0, 0, 0)};
        double locations[][] = {{1.4, 0.2}, {0.2, 0.3}, {1.9, 0.8}, {0.5, 0.5}, {0.7, 0.4}, {1.7, 0.6}};
        
        for (int i = 0; i < locations.length; i++) {
            final double[][] ballMatrixData = { locations[i] };
            final RealMatrix ballCenter = new Array2DRowRealMatrix(ballMatrixData);
            
            this.otherBalls.add(new Ball("ball_" + i, new Circle(ballCenter, 0.029), colors[i], Color.BLACK).getId());
        }
    }
    
    private void createTableSurface() {
        final double[][] pointAMatrixData = { {0.0565, 0.0} };
        final RealMatrix pointA = new Array2DRowRealMatrix(pointAMatrixData);
        
        final double[][] pointBMatrixData = { {2.1, 0.087} };
        final RealMatrix pointB = new Array2DRowRealMatrix(pointBMatrixData);
        
        final double[][] pointCMatrixData = { {0.0565, 1.087} };
        final RealMatrix pointC = new Array2DRowRealMatrix(pointCMatrixData);
        
        final double[][] pointDMatrixData = { {2.1, 1.087} };
        final RealMatrix pointD = new Array2DRowRealMatrix(pointDMatrixData);
        
        this.tableSurface = new TableSurface("tableSurface", new Rectangle(pointA, pointB, pointC, pointD), new Color(240, 70, 70)).getId();
    }
    
    private void createWalls() {
        this.walls = new ArrayList<String>();
        
        double leftSideWallOnePointA[] = {0.1435, 0.0};
        double leftSideWallOnePointB[] = {1.0565, 0.0};
        double leftSideWallOnePointC[] = {0.1435, 0.0435};
        double leftSideWallOnePointD[] = {1.0565, 0.0435};
        this.walls.add(this.createWall("leftSideWallOne", leftSideWallOnePointA, leftSideWallOnePointB, leftSideWallOnePointC, leftSideWallOnePointD).getId());
        
        double leftSideWallTwoPointA[] = {1.1435, 0.0};
        double leftSideWallTwoPointB[] = {2.013, 0.0};
        double leftSideWallTwoPointC[] = {1.1435, 0.0435};
        double leftSideWallTwoPointD[] = {2.013, 0.0435};
        this.walls.add(this.createWall("leftSideWallTwo", leftSideWallTwoPointA, leftSideWallTwoPointB, leftSideWallTwoPointC, leftSideWallTwoPointD).getId());  
        
        double backWallPointA[] = {2.0565, 0.087};
        double backWallPointB[] = {2.1, 0.087};
        double backWallPointC[] = {2.0565, 1.0};
        double backWallPointD[] = {2.1, 1.0};
        this.walls.add(this.createWall("backWall", backWallPointA, backWallPointB, backWallPointC, backWallPointD).getId());  
        
        double rightSideWallTwoPointA[] = {1.1435, 1.0435};
        double rightSideWallTwoPointB[] = {2.013, 1.087};
        double rightSideWallTwoPointC[] = {1.1435, 1.087};
        double rightSideWallTwoPointD[] = {2.013, 2.0};
        this.walls.add(this.createWall("rightSideWallTwo", rightSideWallTwoPointA, rightSideWallTwoPointB, rightSideWallTwoPointC, rightSideWallTwoPointD).getId());  
        
        double rightSideWallOnePointA[] = {0.1435, 1.0435};
        double rightSideWallOnePointB[] = {1.0565, 1.0435};
        double rightSideWallOnePointC[] = {0.1435, 1.087};
        double rightSideWallOnePointD[] = {1.0565, 1.087};
        this.walls.add(this.createWall("rightSideWallOne", rightSideWallOnePointA, rightSideWallOnePointB, rightSideWallOnePointC, rightSideWallOnePointD).getId());  
        
        double frontWallPointA[] = {0.0565, 0.087};
        double frontWallPointB[] = {0.1, 0.087};
        double frontWallPointC[] = {0.0565, 1.0};
        double frontWallPointD[] = {0.1, 1.0};
        this.walls.add(this.createWall("frontWall", frontWallPointA, frontWallPointB, frontWallPointC, frontWallPointD).getId());  
    }
    
    private Wall createWall(String id, double pointAData[], double pointBData[], double pointCData[], double pointDData[]) {
        final double[][] pointAMatrixData = { pointAData };
        final RealMatrix pointA = new Array2DRowRealMatrix(pointAMatrixData);
        
        final double[][] pointBMatrixData = { pointBData };
        final RealMatrix pointB = new Array2DRowRealMatrix(pointBMatrixData);
        
        final double[][] pointCMatrixData = { pointCData };
        final RealMatrix pointC = new Array2DRowRealMatrix(pointCMatrixData);
        
        final double[][] pointDMatrixData = { pointDData };
        final RealMatrix pointD = new Array2DRowRealMatrix(pointDMatrixData);
        
        return new Wall(id, new Rectangle(pointA, pointB, pointC, pointD), new Color(117, 73, 25), Color.BLACK);
    }
    
    private void createPockets() {
        this.pockets = new ArrayList<String>();
        
        double frontLeftPocketLocation[] = {0.1, 0.0435};
        this.pockets.add(this.createPocket("frontLeftPocket", frontLeftPocketLocation).getId());
        
        double centerLeftPocketLocation[] = {1.1, 0.0435};
        this.pockets.add(this.createPocket("centerLeftPocket", centerLeftPocketLocation).getId());
        
        double backLeftPocketLocation[] = {2.0435, 0.0435};
        this.pockets.add(this.createPocket("backLeftPocket", backLeftPocketLocation).getId());
        
        double backRigthPocketLocation[] = {2.0435, 1.0435};
        this.pockets.add(this.createPocket("backRigthPocket", backRigthPocketLocation).getId());
        
        double centerRigthPocketLocation[] = {1.1, 1.0435};
        this.pockets.add(this.createPocket("centerRigthPocket", centerRigthPocketLocation).getId());
        
        double frontRigthPocketLocation[] = {0.1, 1.0435};
        this.pockets.add(this.createPocket("frontRigthPocket", frontRigthPocketLocation).getId());
    }
    
    private Pocket createPocket(String id, double center[]) {
        final double[][] pocketMatrixData = { center };
        final RealMatrix pocketCenter = new Array2DRowRealMatrix(pocketMatrixData);
        
        return new Pocket(id, new Circle(pocketCenter, 0.06), Color.BLACK);
    }
}
