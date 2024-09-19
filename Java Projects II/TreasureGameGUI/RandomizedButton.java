import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * TreasureGameGUI
 * You have 50 tries to find 20 treasures on a JFrame-powered GUI board.
 * The buttons start blank and reveal either "O" for empty or "X" for treasure.
 * 
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

public class RandomizedButton extends JButton {
    
    // Instance Variable
    private boolean isTreasure;
    private boolean isPressed;
    private String myLabel = " ";
    private TreasureGame game;
    private TreasureGameGUI parent;

    /**
     * Constructor for objects of class RandomizedButton
     */
    public RandomizedButton(boolean isTreasure, TreasureGame t) {
        //Create JButton
        super();
        
        // Button starts clear
        this.isTreasure = isTreasure;
        this.isPressed = false;
        this.game = t;
        
        // Get action listener. On click, reveal button contents.
        this.addActionListener(new RevealListener(this));
    }
    public RandomizedButton() {
        super();
        this.isTreasure = false;
        this.isPressed = false;
        
        this.addActionListener(new RevealListener(this));
    }
    
    /**
     * reveal()
     * 
     * Serves as both a foundTreasure and foundNothing function.
     * 
     * Updates the button label when it's pressed and returns whether it's
     * a treasure or not.
     */
    public boolean reveal() {
        this.isPressed = true;
        
        if(this.isTreasure) {
            this.setText("$");
            game.attempt();
            game.findTreasure();
            return true;
        }
        else {
            this.setText("O");
            game.attempt();
            return false;
        }
    }
    
    /**
     * Special reveal method for when the game ends.
     * Unlike the regular reveal() method, this one does not cause attempts
     * or find treasure.
     */
    public void revealSpecial() {
        if(this.isTreasure) {
            this.setText("$");
        } else {
            this.setText("O");
        }
    }
    
    public boolean isPressed() {
        return this.isPressed;
    }
    public boolean isTreasure() {
        return this.isTreasure;
    }
    public TreasureGame getGame() {
        return this.game;
    }
}
