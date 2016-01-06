package hadleys.hope.minisims.renderingsystem;

import java.awt.Graphics2D;

/**
 * All entities which are renderable implements this.
 * @author Krista Iltanen
 */
public interface Renderable {
    
    public int getRenderingLevel();
    
    public void render(Graphics2D graphics2D);
}
