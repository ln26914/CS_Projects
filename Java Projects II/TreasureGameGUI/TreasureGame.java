import java.util.Random;
/**
 * TreasureGame
 * You have 50 tries to find 20 treasures on a JFrame-powered GUI board.
 * The buttons start blank and reveal either "O" for empty or "$" for treasure.
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 24th, 2024)
 */

public class TreasureGame {
    // Instance Variables
    private int treasureCount;
    private int attempts;
    private int maxAttempts;
    
    private int treasuresLeft;
    
    private boolean gameOver;
    
    
    /**
     * TreasureGame()
     * 
     * The single most important function in this entire project.
     */
    public TreasureGame() {
        
        // Initialize parameter values.
        treasureCount = 20;
        treasuresLeft = treasureCount;
        maxAttempts = 50;
        attempts = maxAttempts;
        
    }
    
    /**
     * play()
     * 
     * Play the treasure finding game!
     */
    public void play() {
        TreasureGameGUI myGUI = new TreasureGameGUI(this);
    }
    
    /**
     * getAttempts()
     * Return the attempt count
     */
    public int getAttempts() {
        return this.attempts;
    }
    
    /**
     * attempt()
     * Reduces attempt count by 1
     */
    public void attempt() {
        if(attempts > 0) {
            this.attempts--;
        } else {
            gameOver = true;
        }
    }
    
    /**
     * findTreasure()
     * Reduces remaining treasure count by 1
     */
    public void findTreasure() {
        this.treasuresLeft--;
    }
    
    /**
     * getStatus()
     * Returns a string that describes the current status of the game.
     */
    public String getStatus() {
        if(gameOver && treasuresLeft == 0) return "Victory!";
        if(gameOver) return "Defeat...";
        
        else return String.format("Attempts: %d\n Treasures Found: %d, Treasures Left: %d", 
                                  this.attempts, (this.treasureCount - this.treasuresLeft), this.treasuresLeft);
    }
    
    public boolean gameOver() {
        return this.gameOver;
    }
    
    public static void main(String[] args) {
        TreasureGame g = new TreasureGame();
        g.play();
    }
}
