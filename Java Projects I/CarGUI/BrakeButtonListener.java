import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * BrakeButtonListener
 * 
 * A class that simulates the functionality of a car's brake pedal
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 21st, 2024)
 */
public class BrakeButtonListener implements ActionListener {
    private Car car;
    private JLabel speedLabel;
    
    public BrakeButtonListener(Car car, JLabel speedLabel) {
        this.car = car;
        this.speedLabel = speedLabel;
    }
    
    public void actionPerformed(ActionEvent e) {
        car.brake();
        speedLabel.setText("" + car.getSpeed());
    }
}
