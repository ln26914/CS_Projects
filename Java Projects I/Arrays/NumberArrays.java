import java.util.Random;
/**
 * NumberArrays: Implement some methods for managing arrays of numbers
 * 
 * Inputs: ---
 * Outputs: Testing Output
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (June 27th, 2024)
 */
public class NumberArrays
{
    /**
     * Purpose: Test the functionality of the numerical array management
     * functions.
     * Given no arguments, prints the output and returns nothing
     * main(); returns void
     */
    public static void main(String[] args) {
        int[] testArray = {0,1,-2,3,-4,5,-6};
        
        System.out.println("Test Array: {0,1,-2,3,-4,5,-6}");
        System.out.println("Count: " + getCount(testArray));
        System.out.println("Highest Index: " + getHighestIndex(testArray));
        System.out.println("Last Element: " + getLastElement(testArray));
        System.out.println("Maximum: " + findMaximum(testArray));
        System.out.println("Minimum: " + findMinimum(testArray));
        System.out.println("Total: " + calculateSum(testArray));
        System.out.println("Average: " + calculateAverage(testArray));
    }
    
    /**
     * Purpose: Return the number of elements in an array. Empty array = 0
     * Given an array, return the number of elements
     * getCount({1,2,3}) returns 3, getCount({}) returns 0.
     */
    public static int getCount(int[] array) {
        if(array.equals(null)) return 0; // Sentinel value
        
        return array.length;
    }
    
    /**
     * Purpose: Return the maximum index in an array
     * Given an array, return the index of the last item.
     * getHighestIndex({1,2,3}) returns 2, getHighestIndex({1}) returns 0
     */
    public static int getHighestIndex(int[] array) {
        if(array.equals(null)) return -99999; // Sentinel value
        
        return array.length - 1;
    }
    
    /**
     * Purpose: Return the final element of an array. Empty array = 0
     * Given an array, return the final element
     * getLastElement({1,2,3}) returns 3
     */
    public static int getLastElement(int[] array) {
        if(array.equals(null)) return 0; // Sentinel value
        
        return array[getHighestIndex(array)];
    }
    
    /**
     * Purpose: Find the largest element in the array, including negatives
     * Given an array, return the largest element
     * findMaximum({1,2,3}) returns 3, findMaximum({-3,1,-2}) returns 1
     */
    public static int findMaximum(int[] array) {
        if(array.equals(null)) return -99999; // Sentinel value
        
        // Compare the array elements against the first
        int max = array[0];
        
        // Skip the first value when checking the other elements
        // No need to check array[0] again
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) max = array[i];
        }
        
        return max;
    }
    
    /**
     * Purpose: Find the smallest element in the array, including negatives
     * Given an array, return the smallest element
     * findMinimum({1,2,3}) returns 1, findMinimum({-3,1,-2}) returns -3.
     */
    public static int findMinimum(int[] array) {
        if(array.equals(null)) return -99999; // Sentinel value
        
        // Check array elements against the first
        int min = array[0];
        
        // Skip the first value when checking the other elements.
        // No need to check array[0] again.
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min) min = array[i];
        }
        
        return min;
    }
    
    /**
     * Purpose: Calculate the sum of the elements in the array
     * Given an array, return the sum of the elements
     * calculateSum({1,2,3}) returns 6
     */
    public static int calculateSum(int[] array) {
        if(array.equals(null)) return -99999; // Sentinel value
        
        // Sum initial value = 0
        int sum = 0;
        
        // Iterate through array to get the total
        for(int i = 0; i <= getHighestIndex(array); i++) {
            sum += array[i];
        }
        
        // Return result
        return sum;
    }
    
    /**
     * Purpose: Calculate the average of the elements in the array
     * Given an array, return the averate of the elements
     * calculateAverage({1,2,3}) returns 2
     */
    public static double calculateAverage(int[] array) {
        if(array.equals(null)) return -99999; // Sentinel value
        
        // Use the calculate sum and get count to calculate the average
        return (calculateSum(array) / (double) getCount(array));
    }
}
