import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * TreasureGameGUI
 * You have 50 tries to find 20 treasures on a JFrame-powered GUI board.
 * The buttons start blank and reveal either "O" for empty or "$" for treasure.
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

public class TreasureGameGUI extends JFrame {
    
    //Instance Variables
    public TreasureGame game;
    RandomizedButton[] grid = new RandomizedButton[64];
    
    /**
     * Constructor for objects of class TreasureGameGUI
     */
    public TreasureGameGUI(TreasureGame game) {
        boolean bucket[] = new boolean[64];
        this.game = game;
        StatusPanel status = new StatusPanel(game);
        
        String title = "Treasure Game";
        setTitle(title);
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(8,8);
        panel.setLayout(layout);
        
        // Fill the bucket
        for(int i = 0; i < 20; i++) {
            bucket[i] = true;
        }
        for(int i = 20; i < 64; i++) {
            bucket[i] = false;
        }
        
        // Create the grid
        int lastIndex = 64;
        Random random = new Random();
        int rand = 0;
        boolean temp;
        for(int i = 0; i < 64; i++) {
            
            // Get a random boolean value from the bucket
            rand = random.nextInt(lastIndex);
            
            // Make a new button with the new boolean value
            grid[i] = new RandomizedButton(bucket[rand],game);
            panel.add(grid[i]);
            
            // Move selected bucket item to the end
            temp = bucket[rand];
            bucket[rand] = bucket[lastIndex-1];
            bucket[lastIndex-1] = temp;
            
            // Remove the item from the bucket.
            lastIndex--;
        }
        
        add(panel);
        setVisible(true);
    }
    
}
