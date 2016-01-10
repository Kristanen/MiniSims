package hadleys.hope.minisims;

import hadleys.hope.minisims.common.Rectangle;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.renderingsystem.Renderable;
import hadleys.hope.minisims.renderingsystem.RenderingManager;
import java.awt.Graphics2D;
import java.awt.Paint;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Represents the surface of the pool table.
 * @author Krista Iltanen
 */
public class TableSurface extends Entity implements Renderable {
    
    private Rectangle wireframe;
    private Paint colour;
    
    /**
     * Constructor for the surface of the pool table.
     * @param id Unique identifier for the table surface.
     * @param wireframe Represents the boundaries of the table surface.
     * @param colour Colour of the table surface.
     */
    public TableSurface(String id, Rectangle wireframe, Paint colour) {
        super(id);
        this.wireframe = wireframe;
        this.colour = colour;
    }

    @Override
    public void update(double deltaTime) {
        // Does nothing
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setPaint(this.colour);
        
        double w = this.wireframe.getWidth();
        double h = this.wireframe.getHeight();
        
        RealMatrix leftUpperCorner = this.wireframe.getPoints().get(0);
        graphics2D.fillRect((int)(leftUpperCorner.getEntry(0, 0) / RenderingManager.SCALE_IN_METERS),
                (int)(leftUpperCorner.getEntry(0, 1) / RenderingManager.SCALE_IN_METERS),
                (int)(this.wireframe.getWidth() / RenderingManager.SCALE_IN_METERS),
                (int)(this.wireframe.getHeight() / RenderingManager.SCALE_IN_METERS));
    }

    @Override
    public int getRenderingLevel() {
        return 0;
    }
}
