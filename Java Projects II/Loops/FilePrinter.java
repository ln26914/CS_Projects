import java.util.Scanner;
import java.io.*;
/**
 * FilePrinter: Print out the contents of a file and add line numbers.
 * 
 * Input: File Name (hardcoded)
 * Output: Line Numbers + File Contents
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * 
 * @version 0.1 (June 17th 2024)
 */
public class FilePrinter
{
    public static int main(String[] args) throws IOException {
        // Define Variables and Input: Target file to read
        File targetFile = new File ("data.txt");
        Scanner readFile = new Scanner(targetFile);
        int lineNum = 1; // Line numbers
        
        // Output: Print File Contents with Line Numbers
        while(readFile.hasNext()) {
            System.out.printf("%2d. %s\n", lineNum, readFile.nextLine());
            lineNum += 1;
        }
        
        readFile.close();
        return 0;
        
    }
}
