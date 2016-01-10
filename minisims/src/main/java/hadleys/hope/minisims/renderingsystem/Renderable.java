package hadleys.hope.minisims.renderingsystem;

import java.awt.Graphics2D;

/**
 * All entities which are renderable implement this.
 * @author Krista Iltanen
 */
public interface Renderable {
    
    public int getRenderingLevel();
    
    /**
     * Renders the entity.
     * @param graphics2D 
     */
    public void render(Graphics2D graphics2D);
}
