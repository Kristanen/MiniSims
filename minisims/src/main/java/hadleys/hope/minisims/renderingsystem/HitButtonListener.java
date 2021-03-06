package hadleys.hope.minisims.renderingsystem;

import hadleys.hope.minisims.Ball;
import hadleys.hope.minisims.PoolGame;
import hadleys.hope.minisims.entitysystem.EntityManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.dyn4j.geometry.Vector2;

/**
 * Takes care of the hits.
 * Calculates the force which is applied to the white ball and
 * validates the power and angle fields.
 * @author Krista Iltanen
 */
public class HitButtonListener implements ActionListener {
    
    private static final double MAX_POWER = 500000.0;
    
    private JTextField power;
    private JTextField angle;
    
    private JLabel currentStrokes;
    
    /**
     * Creates new HitBUtton listener
     * @param power Power text field
     * @param angle Angle text field
     * @param currentStrokes Field which holds the current points
     */
    public HitButtonListener(JTextField power, JTextField angle, JLabel currentStrokes) {
        this.power = power;
        this.angle = angle;
        this.currentStrokes = currentStrokes;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String whiteBallId = PoolGame.get().getPoolTable().getWhiteBall();
        Ball whiteBall = (Ball) EntityManager.get().getEntity(whiteBallId);
        
        Double power = null;
        Double angle = null;
        
        try {
            power = Double.parseDouble(this.power.getText()) / 100.0;
            
            if (power > 1.0 || power < 0.0) {
                power = null;
                throw new Exception();
            }
            
        } catch (Exception ex) {
            this.power.setText("Invalid input!");
        }
        
        try {
            angle = Double.parseDouble(this.angle.getText());
            
            // Angle to radians from degrees
            angle = angle * (Math.PI / 180);
        } catch (Exception ex) {
            this.angle.setText("Invalid input!");
        }
        
        if (power != null && angle != null) {
            // Calculation for the force
            double forceMagnitude = power * MAX_POWER;
            
            double forceX = Math.cos(angle) * forceMagnitude;
            double forceY = (-1.0) * Math.sin(angle) * forceMagnitude;
            
            whiteBall.hit(new Vector2(forceX, forceY));
            this.currentStrokes.setText(Integer.toString(PoolGame.get().getHits()));
        }
    }    
}
