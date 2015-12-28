package hadleys.hope.minisims.renderingsystem;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    public Window(final String title, final int width, final int height) {
        super.setTitle(title);
        super.setSize(width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.add(new DrawingSurface());
    }
}
