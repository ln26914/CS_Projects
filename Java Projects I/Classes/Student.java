
/**
 * Student Class: Simulate a university student with the following
 * parameters:
 * 
 * First name, last name and student ID
 *
 * @author Noah Boyd 5550203507
 * @version v0.1 (July 8th 2024)
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * 
 * GeeksforGeeks. (July 7th, 2024). Java String format() method with examples. 
 * GeeksforGeeks. Retrieved July 9, 2024, from https://www.geeksforgeeks.org/
 * java-string-format-method-with-examples/
 * 
 * Not executable directly as it lacks a main() function.
 */
public class Student {
    // Instance Variables
    private int myCSID;
    public static int NEXT_CSID = 1;
    
    private String firstName = "";
    private String lastName = "";
    

    /**
     * Constructor for objects of class Student
     */
    public Student(String firstName, String lastName) {
        // Store name
        this.firstName = firstName;
        this.lastName = lastName;
        
        // Assign CSID
        this.myCSID = NEXT_CSID;
        
        // Advance NEXT_CSID
        NEXT_CSID++;
    }

    /**
     * getFirstName
     * 
     * Returns the first name of this Student object
     * student1.getFirstName() returns "Bart"
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * getLastName
     * 
     * Returns the last name of this Student object
     * student1.getLastName() returns "Simpson"
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * getCSID
     * 
     * Returns the CSID of this Student object
     * student1.getLastName() returns 1
     */
    public int getCSID() {
        return this.myCSID;
    }
    
    /**
     * toString
     * 
     * Returns the contained data as a pretty string.
     * 
     * Formatted String: "%s, %s \nCSID: %d", 
     * this.getLastName(), this.getFirstName, this.getCSID
     * 
     * Result:
     * "Bart, Simpson
     * CSID: 007"
     * 
     * NOTE: toString has a newline character. Keep this in mind when
     * using System library to print.
     */
    public String toString() {
        
        // Assign a formatted string to the outputString variable
        String outputString = String.format("%s, %s \nCSID: %d",
        this.getLastName(), this.getFirstName(), this.getCSID());
        
        return outputString;
        
    }
}
