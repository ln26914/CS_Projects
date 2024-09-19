import java.util.Random;
/**
 * Simulate an electric scooter with a brand name, color, price and speed.
 * 
 * Extra: Add a licence plate mechanic to make every scooter identifiable,
 * freeing up variable naming conventions.
 * 
 * Did I go overboard? Yes. Am I proud of the code I've written? Absolutely.
 * 
 * Developer's Note: Member functions are sorted with respect to their
 * function. Getters with getters, setters with setters, etc.
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * 
 * Oracle. (n.d.). Primitive data types. Java Tutorials. 
 * Retrieved July 6, 2024, from https://docs.oracle.com/javase/tutorial/java/
 * nutsandbolts/datatypes.html#:~:text=byte%3A%20The%20byte%20data%20type,
 * the%20memory%20savings%20actually%20matters.
 *
 * @author Noah Boyd (5550203507)
 * @version 0.1 July 5th 2024
 */
public class ElectricScooter
{
    // instance variables
    
    private String brandName;
    private int licenseID; // integer value
    public static int LICENSE_ID = 0; // tracks all license plates
    
    // To get the actual RGB values, add 128 to the byte color values.
    // Byte values range from -128 to 127.
    private byte[] color = {0,0,0}; // Use RGB and add 128.
    
    private double price; // Truncate to 2 decimal places
    
    private double speed = 0.0; // Speed given in Miles/hour
    
    /**
     * Test the ElectricScooter
     */
    public static void main(String[] args) {
        
        //Define Variables
        ElectricScooter scooter1 = new ElectricScooter("Apollo", 1099.99);
        ElectricScooter scooter2 = new ElectricScooter("Niu", 640.00);
        
        //Display scooters
        System.out.printf("Scooter 1: %s (# %d) %f \n",
                            scooter1.getBrand(), scooter1.getID(),
                            scooter1.getPrice());
                            
        System.out.printf("Scooter 2: %s (# %d) %f \n",
                            scooter2.getBrand(), scooter2.getID(),
                            scooter2.getPrice());
        
        //Accelerate scooter1
        scooter1.accelerate();
        
        System.out.printf("Scooter 1 (# %d): %f \n", 
                            scooter1.getID(), scooter1.getSpeed());
        System.out.printf("Scooter 2 (# %d): %f \n",
                            scooter2.getID(), scooter2.getSpeed());
        
        //Accelerate scooter2 to match
        scooter2.accelerate();
        
        System.out.printf("Scooter 1 (# %d): %f \n", 
                            scooter1.getID(), scooter1.getSpeed());
        System.out.printf("Scooter 2 (# %d): %f \n",
                            scooter2.getID(), scooter2.getSpeed());
        
        //Brake scooter1
        scooter1.brake();
        
        System.out.printf("Scooter 1 (# %d): %f \n", 
                            scooter1.getID(), scooter1.getSpeed());
        System.out.printf("Scooter 2 (# %d): %f \n",
                            scooter2.getID(), scooter2.getSpeed());
        
        //Brake scooter2 to match
        scooter2.brake();
        
        System.out.printf("Scooter 1 (# %d): %f \n", 
                            scooter1.getID(), scooter1.getSpeed());
        System.out.printf("Scooter 2 (# %d): %f \n",
                            scooter2.getID(), scooter2.getSpeed());
    }
    
    /**
     * Constructor for objects of class ElectricScooter
     * Takes the brand name and price of the scooter
     */
    public ElectricScooter(String brandName, double price) {
        this.brandName = brandName;
        this.price = price;
        this.licenseID = LICENSE_ID;
        LICENSE_ID++;
    }
    
    /**
     * getPrice
     * Returns the double value representing this scooter's price.
     * No parameters.
     * 
     * redScooter.getPrice() returns a single double value for the price
     * in USD.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * getBrand
     * Returns the brand of the electric scooter
     * No parameters.
     * 
     * redScooter.getPrice() returns a String containing the brand name.
     */
    public String getBrand() {
        return this.brandName;
    }
    
    /**
     * getColor
     * Returns a 3-member integer array, based on the color bytes.
     * No parameters.
     * 
     * redScooter.getColor() returns a three-member integer array for
     * redScooter's RGB values.
     */
    public int[] getColor() {
        
        // Get the unformatted return RGB values
        int[] returnRGB = {this.color[0], this.color[1], this.color[2]};
        
        // Format the RGB values to return.
        // (-128, 127) --> (0, 255)
        returnRGB[0] += 128;
        returnRGB[1] += 128;
        returnRGB[2] += 128;
        
        // Return formatted color
        return returnRGB;
    }
    
    /**
     * getSpeed
     * Returns a double value, the scooter's speed in miles/hour
     * No parameters.
     * 
     * redScooter.getSpeed() returns a double value that represent's this
     * scooter's speed.
     */
    public double getSpeed() {
        return this.speed;
    }
    
    /**
     * getID
     * Returns the integer ID of the scooter.
     * 
     * redScooter.getID() returns the scooter's ID number
     */
    public int getID() {
        return this.licenseID;
    }
    
    /**
     * setColor
     * Given a 3-member integer array, set the color of this scooter.
     * Returns whether a complete RGB array was entered.
     * 
     * setColor({255,255,255}) sets the color bytes to {127,127,127},
     * representing the color white.
     * 
     * If an RGB value is negative, set to 0. If it's > 255, set to 255.
     * If newColor has 0 elements, return false.
     * If newColor has 1-2 elements, keep untargeted RGB values.
     * If newColor has 4≤ elements, use only the first three.
     */
    public void setColor(int[] newColor) {
        for(int i = 0; i < 3; i++) {
            // If we're at the end of the newColor array, stop.
            
            //Bracket the newColor values:
            if(newColor[i] > 255) newColor[i] = 255;
            if(newColor[i] < 0 ) newColor[i] = 0;
            newColor[i] -= 128; // format to permitted byte range
            
            // Reassign color value
            this.color[i] = (byte) newColor[i];
            
            // Leave if we're at the end of the input array
            if(i == newColor.length-1) i = 3;
            
        }
    }
    
    /**
     * Accelerate
     * increase the scooter's speed by 2.5 mph.
     * No parameters, Returns nothing.
     * 
     * redScooter.Accelerate() increments the speed by 2.5 mph.
     */
    public void accelerate() {
        this.speed += 2.5;
    }
    
    /**
     * Brake
     * decrease the scooter's speed by 1.5 mph.
     * No parameters, Returns nothing.
     * 
     * redScooter.Brake() increments the speed by -1.5 mph.
     */
    public void brake() {
        this.speed -= 1.5;
    }
}
