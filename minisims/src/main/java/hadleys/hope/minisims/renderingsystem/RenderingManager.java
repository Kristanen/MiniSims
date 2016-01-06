package hadleys.hope.minisims.renderingsystem;

import hadleys.hope.minisims.Manager;
import hadleys.hope.minisims.entitysystem.EntityManager;
import java.awt.EventQueue;
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
    
    public static void startUp() {
        renderingManager = new RenderingManager();
    }
    
    public static void shutDown() {
        if (renderingManager.window != null) {
            // Destroy window
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
    }
}
