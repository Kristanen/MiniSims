package hadleys.hope.minisims;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import hadleys.hope.minisims.common.Circle;
import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.renderingsystem.Renderable;

public class Ball extends Entity implements Renderable {
    
    private Paint fill;
    private Paint edge;
    private Circle wireframe;
    
    public Ball(String id, Circle wireframe, Paint fill, Paint edge) {
        super(id);
        this.wireframe = wireframe;
        this.fill = fill;
        this.edge = edge;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        int diameter = (int) (this.wireframe.getRay() * 2.0);
        int leftCornerX = (int)(this.wireframe.getCenter().getEntry(0, 0) - this.wireframe.getRay());
        int leftCornerY = (int)(this.wireframe.getCenter().getEntry(0, 1) - this.wireframe.getRay());
        
        graphics2D.setPaint(this.fill);
        graphics2D.fillOval(leftCornerX, leftCornerY, diameter, diameter);
        
        graphics2D.setPaint(this.edge);
        graphics2D.drawOval(leftCornerX, leftCornerY, diameter, diameter);
    }   
}
