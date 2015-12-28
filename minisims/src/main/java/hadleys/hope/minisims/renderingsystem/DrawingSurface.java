package hadleys.hope.minisims.renderingsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawingSurface extends JPanel {
    
    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        
        for(Renderable object : RenderingManager.get().getRenderableObjects()) {
            object.render(graphics2D);
        }
    }
}
