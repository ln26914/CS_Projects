import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * TreasureGameGUI
 * You have 50 tries to find 20 treasures on a JFrame-powered GUI board.
 * The buttons start blank and reveal either "O" for empty or "$" for treasure.
 * 
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 24th, 2024)
 */

public class UpdateButtonListener implements ActionListener {
    private TreasureGame game;
    private JLabel statusLabel;
    
    public UpdateButtonListener(TreasureGame game, JLabel statusLabel) {
        this.game = game;
        this.statusLabel = statusLabel;
    }
    
    // Update game status on a press.
    public void actionPerformed(ActionEvent e) {
        statusLabel.setText(game.getStatus());
    }
}
