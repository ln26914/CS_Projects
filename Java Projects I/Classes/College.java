
/**
 * College Class: Simulate a university student with the following
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
 * Not executable directly as it lacks a main() function.
 */
public class College
{
    // Instance Variable
    public int courseCount = 0;
    private String collegeName;
    private String myAddress;
    private Course[] myCourses = new Course[1000];
    

    /**
     * Constructor for objects of class College
     */
    public College(String collegeName, String address) {
        // Store address and name
        this.collegeName = collegeName;
        this.myAddress = address;
    }

    /**
     * getAddress
     * 
     * Returns the address of this College object.
     */
    public String getAddress() {
        // Return the address
        return this.myAddress;
    }
    
    /**
     * getName
     * 
     * Returns the name of this College object.
     */
    public String getName() {
        // Return the college name
        return this.collegeName;
    }
    
    /**
     * addCourse
     * 
     * Adds an additional course to this college.
     * college1.addCourse(course1) adds course1 to the college1.
     */
    public void addCourse(Course newCourse) {
        myCourses[courseCount] = newCourse;
        courseCount++;
    }
    
    /**
     * toString
     * 
     * print an abbreviated report of this college. This abbreviated report
     * doesn't expand each course. Instead, it only lists their name and
     * CRN.
     */
    public String toString() {
        
        // Define variables
        String outputString = String.format("%s\n%s\n", 
                                this.getName(), this.getAddress());
        
        // Iterate through courses and provide a little bit of information
        int index = 0; // Increment variable
        while(!myCourses[index].equals(null)) {
            // Print out the course name, title, and seats.
            outputString += String.format(
                            "%s, CRN: %d",
                            myCourses[index].getTitle(), 
                            myCourses[index].getCRN(),
                            myCourses[index]);
            // Don't print out confidential student data.
        }
        
        return outputString;
    }
    
    /**
     * toStringXL()
     * Print out a complete report of every course available.
     * Note: The output will be very large.
     */
    public String toStringXL() {
        
        // Define variables
        String outputString = String.format("%s\n%s\n", 
                                this.getName(), this.getAddress());
        
        // Iterate through courses and provide a little bit of information
        for(int i = 0; i < this.courseCount; i++) {
            // Print out the course name, title, and seats.
            outputString += (myCourses[i].toString() + "\n");
        }
        
        return outputString;
    }
}
