package hadleys.hope.minisims.renderingsystem;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

/**
 * Help in creating this class was looked from http://www.dreamincode.net/forums/topic/113451-java-game-actually-the-most-efficient-way-to-repaint/
 * Performs active rendering for all renderable objects.
 * @author Krista Iltanen
 */
public class DrawingSurface extends Canvas {
    
    /**
     * Constructor for the drawing surface.
     */
    public DrawingSurface() {
        super.setIgnoreRepaint(true);
    }
    
    @Override
    public void repaint() {
        super.repaint();
        
        // Get buffer
        BufferStrategy bufferStrategy = super.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        
        // Clear buffer
        graphics.setColor(super.getBackground());
        graphics.fillRect(0, 0, super.getWidth(), super.getHeight());
        
        // Draw renderable objects
        this.paintRenderableObjects(graphics);
        
        graphics.dispose();
        
        // Swap buffers
        bufferStrategy.show();
        
        // Sync the display on some systems.
        // (on Linux, this fixes event queue problems)
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void paintRenderableObjects(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        
        for(Renderable object : RenderingManager.get().getRenderableObjects()) {
            object.render(graphics2D);
        }
    }
}
