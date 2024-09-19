
/**
 * UnitConversions: Convert units of spead and temperature measurement to
 * their metric or imperial counterparts.
 * 
 * convertMphToKph: Converts Mph to Kph
 * convertKphToMph: Converts Kph to Mph
 * convertFToC: Convert Fahrenheit to Celsius ** EXTRA METHOD **
 * convertCToF: Convert Celsius to Fahrenheit
 *
 * @author Noah Boyd 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * McFadyen, R. (2015). Java with BlueJ Part I.
 * 
 * @version 0.1 (June 24th 2024)
 * 
 */
public class UnitConversions
{
    public static void main(String[] args) {
        // Test functions here
        
        // Testing convertMphToKph()
        System.out.println("Convert 100 miles per hour to kilometers " +
                           "(Should be 160.9): " + convertMphToKph(100.0));
        System.out.println("Convert 65 miles per hour to kilometers " +
                           "(Should be 104.585): " + convertMphToKph(65.0));
        
        // Testing convertKphToMph()
        System.out.println("Convert 160 kilometers per hour to miles" +
                           "(Should be 99.44): " + convertKphToMph(160.0));
        System.out.println("Convert 100 kilometers per hour to miles " +
                           "(Should be 62.150): " + convertMphToKph(100.0));
        
        // Testing convertFToC() ** Extra **
        System.out.println("Convert 212 degrees Fahrenheit to Celsius "+
                           "(Should be 100.0): " + convertFToC(212.0));
        System.out.println("Convert 73.4 degrees Celsius to Fahrenheit "+
                           "(Should be 23): " + convertFToC(73.4));
        
        //Testing convertCToF()
        System.out.println("Convert 100 degrees Celsius to Fahrenheit "+
                           "(Should be 212.0): " + convertCToF(100.0));
        System.out.println("Convert 23 degrees Celsius to Fahrenheit "+
                           "(Should be 73.4): " + convertCToF(23.0));
    }
    
    /**
     * Purpose: Convert speed in Miles Per Hour to Kilometers Per Hour
     * Input/Output: Given speed in Mph, return speed in Kph
     * Examples:
     * convertMphToKph(100.00) returns 160.90
     */
    public static double convertMphToKph(double mph) {
        //1 mile per hour = 1.609 kilometers per hour
        return mph * 1.609;
    }
    
    /**
     * Purpose: Convert speed in Kilometers Per Hour to Miles Per Hour
     * Input/Output: Given speed in Kph, return speed in Mph
     * Examples:
     * convertKphToMph(100.00) returns 62.150
     */
    public static double convertKphToMph(double kph) {
        // 1 kilometer per hour = 0.6215 miles per hour
        return kph / 1.609;
    }
    
    /**
     * Purpose: Convert temperature in Fahrenheit to Celsius
     * Input/Output: Given temperature in Fahrenheit, 
     *               return temperature in Celsius
     * Examples:
     * convertFtoC(212) returns 100
     */
    public static double convertFToC(double fahrenheit) {
        // Celsius = (Fahrenheit - 32) / 1.8
        return (fahrenheit - 32) / 1.8;
    }
    
    /**
     * Purpose: Convert temperature in Celsius to Fahrenheit
     * Input/Output: Given temperature in Celsius, 
     *               return temperature in Fahrenheit
     * Examples:
     * convertCtoF(212) returns 413.6
     */
    public static double convertCToF(double celsius) {
        //Fahrenheit = (Celsius * 1.8
        return (1.8 * celsius) + 32;
    }
}
