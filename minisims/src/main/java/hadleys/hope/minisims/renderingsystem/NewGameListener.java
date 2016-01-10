package hadleys.hope.minisims.renderingsystem;

import hadleys.hope.minisims.PoolGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * Starts new game when button is clicked
 * @author Krista Iltanen
 */
public class NewGameListener implements ActionListener {
    
    private JLabel currentStrokes;
    
    /**
     * Constructor for the NewGameListener.
     * @param currentStrokes 
     */
    public NewGameListener(JLabel currentStrokes) {
        this.currentStrokes = currentStrokes;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.currentStrokes.setText("0");
        PoolGame.get().clearGame();
    }
}
