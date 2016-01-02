package hadleys.hope.minisims.renderingsystem;

import hadleys.hope.minisims.Manager;
import hadleys.hope.minisims.entitysystem.EntityManager;
import java.awt.EventQueue;
import java.util.List;

/**
 * Manages rendering machinery like window and active rendering surface.
 * @author Krista Iltanen
 */
public class RenderingManager implements Manager {
    
    public static final double SCALE_IN_METRES = 0.002;
    
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
    
    private RenderingManager() {
        this.window = null;
    }
    
    public void createWindow() {
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                window = new Window("Mini Pool", 1000, 700);
                window.setVisible(true);
            }
        });
    }
    
    public List<Renderable> getRenderableObjects() {
        return EntityManager.get().getRenderableObjects();
    }

    @Override
    public void update(double deltaTime) {
        // Rendering is done in its own thread nothing to do here.
    }
}
