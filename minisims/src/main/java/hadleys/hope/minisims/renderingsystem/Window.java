package hadleys.hope.minisims.renderingsystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Help in creating this class was looked from http://www.dreamincode.net/forums/topic/113451-java-game-actually-the-most-efficient-way-to-repaint/
 * The games window.
 * @author Krista Iltanen
 */
public class Window extends JFrame {
    
    private final static int NUMBER_OF_BUFFERS_IN_DOUBLE_BUFFERING = 2;
    
    private DrawingSurface drawingSurface;
    
    public Window(final String title, final int width, final int height) {
        super(title);
        super.setTitle(title);
        super.setSize(width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        super.add(this.actionBar(), BorderLayout.PAGE_END);
        super.add(this.statusBar(), BorderLayout.PAGE_START);
        
        this.drawingSurface = new DrawingSurface();
        super.add(this.drawingSurface, BorderLayout.CENTER);
        
        super.setVisible(true);
        
        this.drawingSurface.createBufferStrategy(NUMBER_OF_BUFFERS_IN_DOUBLE_BUFFERING);
    
        super.setResizable(false);
        super.pack();
    }
    
    public void render() {
        this.drawingSurface.repaint();
    }
    
    private JPanel actionBar() {
        JPanel actionBar = new JPanel();
        actionBar.setLayout(new GridLayout(1,5));
        
        actionBar.add(new JTextField());
        actionBar.add(new Label("Power in %"));
        
        actionBar.add(new JTextField());
        actionBar.add(new Label("Angle in degrees"));
        
        actionBar.add(new JButton("Hit"));
        
        return actionBar;
    }
    
    private JPanel statusBar() {
        JPanel statusBar = new JPanel();
        statusBar.setLayout(new GridLayout(1,3));
        
        statusBar.add(new Label("High score: "));
        statusBar.add(new Label("Currents strokes: "));
        
        statusBar.add(new JButton("New game"));
        
        return statusBar;
    }
}
