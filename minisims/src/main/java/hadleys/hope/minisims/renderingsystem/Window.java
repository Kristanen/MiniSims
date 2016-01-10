package hadleys.hope.minisims.renderingsystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    
    private JTextField angle;
    private JTextField power;
    
    private JLabel currentPoints;
    
    private JButton hitButton;
    private JButton newGameButton;
    
    public Window(final String title, final int width, final int height) {
        super(title);
        super.setTitle(title);
        super.setSize(width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        super.add(this.actionBar(), BorderLayout.PAGE_END);
        super.add(this.statusBar(), BorderLayout.PAGE_START);
        
        this.hitButton.addActionListener(new HitButtonListener(power, angle, currentPoints));
        this.newGameButton.addActionListener(new NewGameListener(this.currentPoints));
        
        this.drawingSurface = new DrawingSurface();
        super.add(this.drawingSurface, BorderLayout.CENTER);
        
        super.setVisible(true);
        
        this.drawingSurface.createBufferStrategy(NUMBER_OF_BUFFERS_IN_DOUBLE_BUFFERING);
    
        super.setResizable(false);
        super.pack();
    }
    
    public void setIsHitButtonEnables(boolean isEnabled) {
        this.hitButton.setEnabled(isEnabled);
    }
    
    public boolean isHitButtonEnabled() {
        return this.hitButton.isEnabled();
    }
    
    public int getCurrentHitsLabel() {
        return Integer.parseInt(this.currentPoints.getText());
    }
    
    public void setCurrentHitsLabel(int hits) {
        this.currentPoints.setText(Integer.toString(hits));
    }
    
    public void render() {
        this.drawingSurface.repaint();
    }
    
    private JPanel actionBar() {
        JPanel actionBar = new JPanel();
        actionBar.setLayout(new GridLayout(1,5));
        
        this.power = new JTextField();
        this.power.setName("powerField");
        actionBar.add(power);
        actionBar.add(new JLabel("Power in %"));
        
        this.angle = new JTextField();
        this.angle.setName("angleField");
        actionBar.add(angle);
        actionBar.add(new JLabel("Angle in degrees"));
        
        this.hitButton = new JButton("Hit");
        this.hitButton.setName("hitButton");
        actionBar.add(this.hitButton);
        
        return actionBar;
    }
    
    private JPanel statusBar() {
        JPanel statusBar = new JPanel();
        statusBar.setLayout(new GridLayout(1,3));
        
        statusBar.add(new JLabel("Currents points: "));
       
        this.currentPoints = new JLabel("0");
        this.currentPoints.setName("currentPoints");
        statusBar.add(this.currentPoints);
        
        this.newGameButton = new JButton("New game");
        this.newGameButton.setName("newGameButton");
        statusBar.add(this.newGameButton);
        
        return statusBar;
    }
}
