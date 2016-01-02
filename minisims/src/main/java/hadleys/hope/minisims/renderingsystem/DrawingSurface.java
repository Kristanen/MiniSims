package hadleys.hope.minisims.renderingsystem;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import javax.swing.Timer;

/**
 * Help in creating this class was looked from http://www.dreamincode.net/forums/topic/113451-java-game-actually-the-most-efficient-way-to-repaint/
 * Performs active rendering for all renderable objects.
 * @author Krista Iltanen
 */
public class DrawingSurface extends Canvas {
    
    private final static int SIXTY_FPS_IN_MILLISECONDS = 17; 
    
    private boolean isDoingRepaint;
    
    public DrawingSurface() {
        super.setIgnoreRepaint(true);
        
        this.isDoingRepaint = false;
        
        // Repaint will be used to call repaint 60 times per second (every 17 ms)
        new Timer(SIXTY_FPS_IN_MILLISECONDS, new RepaintCaller(this)).start();
    }
    
    @Override
    public void repaint() {
        
        // Check that doesn't try to repaint twice the same buffer
        if (this.isDoingRepaint) {
            return;
        }
        
        this.isDoingRepaint = true;
        
        super.repaint();
        
        // Get buffer
        BufferStrategy bufferStrategy = super.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        
        // Clear buffer
        graphics.setColor(super.getBackground());
        graphics.fillRect(0, 0, super.getWidth(), super.getHeight());
        
        // Draw renderable objects
        this.paintRenderableObjects(graphics);
        
        // Swap buffers
        bufferStrategy.show();
        Toolkit.getDefaultToolkit().sync();
        
        // Repainting is done
        this.isDoingRepaint = false;
    }
    
    private void paintRenderableObjects(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        
        for(Renderable object : RenderingManager.get().getRenderableObjects()) {
            object.render(graphics2D);
        }
    }
    
    class RepaintCaller implements ActionListener {
        
        private Component component;
        
        public RepaintCaller(Component drawingSurface) {
            this.component = drawingSurface;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            this.component.repaint();
        }
    }
}
