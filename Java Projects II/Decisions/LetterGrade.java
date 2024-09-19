import java.util.Scanner;
/**
 * LetterGrade: Assign a grade based on a percentage.
 * A: 90-100+
 * B: 80-90
 * C: 70-80
 * D: 60-70
 * F: <60
 * 
 * Input: Grade Percent
 * Output: Letter Grade
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * @version 0.1 (June 13th, 2024)
 */
public class LetterGrade
{
    public static void main(String[] args) {
        // Define Variables
        Scanner keyboard = new Scanner(System.in);
        
        double gradePercent = 0.0; // Input: Grade given (default 0)
        char letterGrade = 'F'; // Output: Grade received (default 'F')
        
        // Input the grade percent
        System.out.print("Enter the grade received (%): ");
        gradePercent = keyboard.nextDouble();
        System.out.println();
        
        // Calculate the letter grade
        if(gradePercent >= 90) letterGrade = 'A';
        else if(gradePercent >= 80) letterGrade = 'B';
        else if(gradePercent >= 70) letterGrade = 'C';
        else if(gradePercent >= 60) letterGrade = 'D';
        else letterGrade = 'F';
        
        // Display letter grade
        System.out.println("Letter Grade: " + letterGrade);
    }
}
