import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * AccelerateButtonListener
 * 
 * A class that simulates the functionality of a car's acceleration pedal
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 21st, 2024)
 */
public class AccelerateButtonListener implements ActionListener {
    private Car car;
    private JLabel speedLabel;
    
    public AccelerateButtonListener(Car car, JLabel speedLabel) {
        this.car = car;
        this.speedLabel = speedLabel;
    }
    
    public void actionPerformed(ActionEvent e) {
        car.accelerate();
        speedLabel.setText("" + car.getSpeed());
    }
}
