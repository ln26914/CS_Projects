
/**
 * Car
 * 
 * A class that simulates the functionality of a car.
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 21st, 2024)
 */
public class Car {
    // Instance Variables
    private int yearModel;
    private String make;
    private int speed;

    /**
     * Constructor for objects of class Car
     */
    public Car(String make, int yearModel) {
        this.make = make;
        this.yearModel = yearModel;
        this.speed = 0;
    }

    /**
     * Getters for the member variables
     */
    public int getYear() {
        return this.yearModel;
    }
    public int getSpeed() {
        return this.speed;
    }
    public String getMake() {
        return this.make;
    }
    
    /**
     * Brake/Accelerate methods
     * 
     * Reduce/Increase the speed member variable
     */
    public void accelerate() {
        this.speed += 8;
    }
    public void brake() {
        this.speed -= 6;
        if(speed < 0) speed = 0;
    }
}
