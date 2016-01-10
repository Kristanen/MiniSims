package hadleys.hope.minisims.renderingsystem;

import hadleys.hope.minisims.Ball;
import hadleys.hope.minisims.Manager;
import hadleys.hope.minisims.PoolGame;
import hadleys.hope.minisims.entitysystem.EntityManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages rendering machinery like window and active rendering surface.
 * @author Krista Iltanen
 */
public class RenderingManager implements Manager {
    public static final double SCALE_IN_METERS = 0.002;
    
    private static RenderingManager renderingManager;
    
    /**
     * Activates the Rendering Manager.
     */
    public static void startUp() {
        renderingManager = new RenderingManager();
    }
    
    /**
     * SHuts down the Rendering Manager.
     */
    public static void shutDown() {
        if (renderingManager.window != null) {
            // Destroy window
        }
        
        if (renderingManager.window != null) {
            renderingManager.window.dispose();
        }
        
        renderingManager = null;
    }
    
    public static RenderingManager get() {
        
        if (renderingManager == null) {
            throw new IllegalStateException("Rendering Manager has not been initialized.");
        }
        
        return renderingManager;
    }
    
    private Window window;
    private Comparator<Renderable> renderableComparator;
    
    private RenderingManager() {
        this.window = null;
        this.renderableComparator = new Comparator<Renderable>() {
            
            @Override
            public int compare(Renderable o1, Renderable o2) {
                return o1.getRenderingLevel() - o2.getRenderingLevel();
            }
        };
    }
    
    public Window getWindow() {
        return this.window;
    }
    
    /**
     * Creates the window.
     */
    public void createWindow() {
        window = new Window("Mini Pool", 1100, 700);
        window.setVisible(true);
    }
    
    public List<Renderable> getRenderableObjects() {
        List<Renderable> renderableObjects = EntityManager.get().getRenderableObjects();
        Collections.sort(renderableObjects, this.renderableComparator);
        return renderableObjects;
    }

    @Override
    public void update(double deltaTime) {
        // Rendering is done in its own thread nothing to do here.
        this.window.render();
        
        // Refresh current hits label if necessary
        if (this.window.getCurrentHitsLabel() != PoolGame.get().getHits()) {
            this.window.setCurrentHitsLabel(PoolGame.get().getHits());
        }
        
        // Hit button enabled if all balls have stopped
        boolean allBallsAreStill = true;
        for (String ballId : PoolGame.get().getPoolTable().getAllColourBalls()) {
            Ball ball = (Ball) EntityManager.get().getEntity(ballId);
            
            if (ball == null) {
                continue;
            }
            
            if (!ball.isStill()) {
                allBallsAreStill = false;
            }
        }
        
        Ball whiteBall = (Ball) EntityManager.get().getEntity(PoolGame.get().getPoolTable().getWhiteBall());
        if ((allBallsAreStill && whiteBall.isStill()) && !this.window.isHitButtonEnabled()) {
            this.window.setIsHitButtonEnabled(true);
        }
        
        else if ((!(allBallsAreStill && whiteBall.isStill())) && this.window.isHitButtonEnabled()) {
            this.window.setIsHitButtonEnabled(false);
        }
    }
}
