import java.util.Scanner;
import java.io.*;

/**
 * Save and Load Scoreboard objects from a file.
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 *
 * @author Noah Boyd 5550203507
 * @version 0.1 (July 19th 2024)
 */
public class ScoreboardManager {
    
    // Instance Variables
    // No Instance Variables
    
    /**
     * Main
     * Test the scoreboard save/load functionality
     */
    
    public static void main(String[] args) {
        // Define Variables;
        GameScore[] gameScores = new GameScore[5];
        String[] names = {"Billy","Nicole","Anby","Mia","Wise"};
        int[] scores = {280,265,225,215,189};
        ScoreboardManager mgr = new ScoreboardManager();
        String filename = "cache.txt";
        
        // Load scores into the scoreboard
        for(int i = 0; i < 5; i++) {
            gameScores[i] = new GameScore(names[i], scores[i]);
        }
        
        // Print scoreboard
        System.out.println("Original Scoreboard: ");
        Scoreboard targetScoreboard = new Scoreboard(gameScores);
        System.out.println(targetScoreboard.toString());
        
        // Save Scoreboard
        
        System.out.println("Writing Scoreboard to file: ");
        try {
            mgr.save(targetScoreboard);
        } catch (IOException e) {
            System.out.println("Unable to save the scoreboard to file.");
        }
        
        // Load Scoreboard
        Scoreboard fromDisk = new Scoreboard();
        
        System.out.println("Reading Scoreboard from file: ");
        try {
            fromDisk = mgr.load(filename);
        } catch (IOException e) {
            System.out.println("Unable to load the scoreboard from file.");
        } catch (NullPointerException e) {
            System.out.println("Null Game Score detected.");
        }
        
        // Display loaded scoreboard
        System.out.println("Scoreboard read from disk: ");
        System.out.println(fromDisk.toString());
    }
    
    /**
     * Save
     * 
     * Take a scoreboard of size 5, print its comments, and save it to disk.
     */
    public void save(Scoreboard target) throws IOException {
        // Define Variables
        Scoreboard toSave = new Scoreboard(target.getScores());
        
        
        FileOutputStream fstream = new FileOutputStream("cache.txt");
        ObjectOutputStream outputFile = new ObjectOutputStream(fstream);
        
        // Print Scoreboard Contents
        System.out.println(toSave.toString());
        
        // Save Scoreboard to disk with serialization.
        // use Try/catch to prevent errors
        try {
            outputFile.writeObject(target);
            outputFile.flush();
            outputFile.close();
            
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
        } finally {
            outputFile.close();
        }
        
    }
    
    /**
     * Load
     * 
     * Load a scoreboard from the disk and return it.
     */
    public Scoreboard load (String filename) throws IOException {
        
        // Read in the file created with the save method
        try {
            FileInputStream fstream = new FileInputStream(filename);
            ObjectInputStream inputFile = new ObjectInputStream(fstream);
            
            System.out.println("File Found: " + filename);
            
            Scoreboard newScoreboard = (Scoreboard) inputFile.readObject();
            
            return newScoreboard;
            
        } catch (IOException e) {
            System.out.println("Error when reading file " + filename);
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Unable to find Scoreboard Class.");
            System.out.println("Are you sure you know what you're doing?");
            return null;
        }
    }
    
}
