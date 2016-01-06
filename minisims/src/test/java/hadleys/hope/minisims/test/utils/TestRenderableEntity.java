package hadleys.hope.minisims.test.utils;

import hadleys.hope.minisims.entitysystem.Entity;
import hadleys.hope.minisims.renderingsystem.Renderable;
import java.awt.Graphics2D;

public class TestRenderableEntity extends Entity implements Renderable {

    public TestRenderableEntity(String id) {
        super(id);
    }

    @Override
    public void update(double deltaTime) {
        
    }

    @Override
    public int getRenderingLevel() {
        return 0;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        
    }
}
