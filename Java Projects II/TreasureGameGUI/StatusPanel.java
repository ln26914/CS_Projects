import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * StatusPanel
 * You have 50 tries to find 20 treasures on a JFrame-powered GUI board.
 * The buttons start blank and reveal either "O" for empty or "$" for treasure.
 * 
 * This panel tracks the status of the game.
 * 
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. 2(2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 24th, 2024)
 */

public class StatusPanel extends JFrame {
    
    /**
     * Constructor for objects of class StatusPanel
     */
    
    private TreasureGame game;
    
    public StatusPanel(TreasureGame game) {
        
        this.game = game;
        
        String title = "Treasure game status";
        setTitle(title);
        
        setSize(550,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(2,1);
        panel.setLayout(layout);
        
        
        // Status Panel Content
        JLabel statusLabel = new JLabel(game.getStatus());
        panel.add(statusLabel);
        
        JButton updateButton = new JButton("Update Game Status");
        panel.add(updateButton);
        
        // Controller Section
        updateButton.addActionListener(new UpdateButtonListener(game, statusLabel));
        
        add(panel);
        setVisible(true);
    }
    
}
