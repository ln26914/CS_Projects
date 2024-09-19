
/**
 * Course Class: Simulate a university course with the following
 * parameters:
 * 
 * Title, CRN, seatCount, Student array
 *
 * @author Noah Boyd 5550203507
 * @version v0.1 (July 8th 2024)
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * 
 * JavaTpoint. (July 9th, 2024). Default Parameter in Java. 
 * Retrieved July 9, 2024, from https://www.javatpoint.com/
 * default-parameter-in-java
 * 
 * Not executable directly as it lacks a main() function.
 */
public class Course
{
    // Instance Variables
    private int myCRN; // CRN for this course
    private int fullSeats = 0; // Full seats.
    
    private String title = ""; // Course title
    private Student[] studentList; // Students in the course
    

    /**
     * Constructor for objects of class Course
     */
    public Course(String title, int CRN){        
        // Store title and CRN
        this.title = title;
        this.myCRN = CRN;
                
        // Courses start empty.
        fullSeats = 0;
        
    }

    /**
     * getTitle
     * 
     * Returns the Title of this Course object
     * course1.getTitle() returns "Intro to Computer Science"
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * getCRN
     * 
     * Returns the CRN of this Course object
     * course1.getCRN() returns 001
     */
    public int getCRN() {
        return this.myCRN;
    }
    
    /**
     * toString
     * 
     * Displays all the data for this course.
     * Formatted String: "%s %d \n\n %s \n",
     *                   this.getTitle(), this.getCRN(),
     *                   studentList[i].toString()
     * Iteratively concatenate student toString() from this course's
     * studentList instance variable.
     */
    
    public String toString() {
        //Add the initial format to the output string: Course Title, CRN:
        String outputString = String.format("%s %d \n\n",this.getTitle(),
                                            this.getCRN());
        
        // Iteratively print out the student toString()
        int index = 0; // Increment Variable
        while(studentList[index] != null) {
            // Add Full Seats
            outputString += studentList[index].toString() + "\n"; 
        }
        return outputString;  
    }
    
    /**
     * enroll(Student)
     * 
     * Enrolls the target student into this course, incrementing fullSeats.
     * given a student, adds them to the studentList and returns nothing.
     * 
     * course1.enroll(student1) returns nothing.
     */
    public void enroll(Student target) {
        studentList[this.fullSeats] = target;
        fullSeats++;
    }
}
