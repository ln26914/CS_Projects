import java.util.Scanner;
import java.io.*;

/**
 * Store an array of 5 GameScore objects.
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 *
 * @author Noah Boyd 5550203507
 * @version 0.1 (July 19th 2024)
 */
public class Scoreboard implements Serializable {
    
    // instance variables - replace the example below with your own
    private static final long serialVersionUID = 1L;
    private int ScoreCount = 5;
    private GameScore[] scores = new GameScore[ScoreCount];

    /**
     * Constructor for objects of class Scoreboard
     */
    public Scoreboard(GameScore scores[]) throws IllegalArgumentException {
        
        if(scores.length != this.ScoreCount) 
            throw new IllegalArgumentException();
        
        for(int i = 0; i < this.scores.length; i++) {
            this.scores[i] = new GameScore(scores[i]);
        }
    }
    /**
     * Default Constructor
     */
    public Scoreboard() {
        for(int i = 0; i < ScoreCount; i++) {
            this.scores[i] = new GameScore();
        }
    }
    
    /**
     * toString()
     * 
     * Convert the data in this object to be a string
     * Use field width and format to make the output look prettier.
     */
    
    public String toString() {
        String outputString = String.format("Scores: \n");
        
        for(int i = 0; i < this.ScoreCount; i++) {
            outputString += String.format("%17s %7d\n",
                            this.scores[i].getName(), 
                            this.scores[i].getScore());
        }
        
        outputString += "\n\n";
        
        return outputString;
    }
    
    /**
     * getScores
     * 
     * Returns the scores of this scoreboard.
     */
    public GameScore[] getScores() {
        return this.scores;
    }

    
}
