package hadleys.hope.minisims.renderingsystem;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;


public class RenderingManager {
    
    private static RenderingManager renderingManager;
    
    public static void startUp() {
        renderingManager = new RenderingManager();
    }
    
    public static void shutDown() {
        renderingManager = null;
    }
    
    public static RenderingManager get() {
        
        if (renderingManager == null) {
            throw new IllegalStateException("Rendering Manager has not been initialized.");
        }
        
        return renderingManager;
    }
    
    private List<Renderable> renderableObjects;
    
    private RenderingManager() {
        this.renderableObjects = new ArrayList<Renderable>();
    }
    
    public void createWindow() {
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                Window miniPoolWindow = new Window("Mini Pool", 800, 800);
                miniPoolWindow.setVisible(true);
            }
        });
    }
    
    public List<Renderable> getRenderableObjects() {
        return this.renderableObjects;
    }
    
    public void addRenderableObject(Renderable object) {
        this.renderableObjects.add(object);
    }
    
    public void removeRenderableObjects(Renderable object) {
        this.renderableObjects.remove(object);
    }
}
