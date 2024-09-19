
/**
 * main()
 * The executable class of Module 9 Coding challenge
 *
 * @author Noah Boyd 5550203507
 * @version v0.1 (July 12th, 2024)
 */
public class Main {
    /**
     * Main method
     * No Parameters, No Return Value
     */
    public static void main(String[] args) {
        // Define Variables
        Student student1 = new Student("Noah", "Boyd");
        Student student2 = new Student("Bart", "Simpson");
        
        Course course1 = new Course("Java Programming", 121);
        Course course2 = new Course("Introduction to Computer Science", 121);
        
        College college1 = new College("San Diego Favorite College",
                            "333 N Twin Oaks Valley Road");
        
        // Add courses to the college
        college1.addCourse(course1);
        college1.addCourse(course2);
        
        // Add Bart Simpson and myself to the Java course
        course1.enroll(student1);
        course1.enroll(student2);
        
        // Add Bart Simpson to the Computer Science Course
        course2.enroll(student2);
        
        
        // Optional: Print complete college report 
        // This expands every course at the college.
        System.out.printf("%s \n", college1.toStringXL());
        
        
        // Print course reports
        System.out.printf("%s \n", course1.toString());
        System.out.printf("%s \n", course2.toString());
        
        // Print college report
        System.out.printf("%s \n", college1.toString());
        
    }
}
