import java.util.Scanner;
import java.io.*;

/**
 * Store a player name along with their score.
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 *
 * @author Noah Boyd 5550203507
 * @version 0.1 (July 19th 2024)
 */
public class GameScore implements Serializable {
    // instance variables - replace the example below with your own
    private static final long serialVersionUID = 1L;
    private String name;
    private int score;

    /**
     * Constructor for objects of class GameScore
     */
    public GameScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
    /**
     * Default constructor
     */
    public GameScore() {
        this.name = "Anon";
        this.score = 0;
    }
    /**
     * Copy constructor
     */
    public GameScore(GameScore copy) {
        this.name = copy.getName();
        this.score = copy.getScore();
    }
    
    /**
     * toString()
     * 
     * Convert the data in this object to be a string
     * Use field width and format to make the output look prettier.
     */
    
    public String toString() {
        String outputString = String.format("%s %d", this.name, this.score);
        
        return outputString;
    }
    
    /**
     * setScore
     * 
     * Sets the score of this GameScore object to the specified value.
     */
    public void setScore(int value) {
        this.score = value;
    }
    
    /**
     * setName
     * 
     * Sets the name of this GameScore object to the specified name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * getScore
     * 
     * Sets the score of this GameScore object to the specified value.
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * getName
     * 
     * Sets the name of this GameScore object to the specified name.
     */
    public String getName() {
        return this.name;
    }


    
}
