import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * CarView
 * 
 * A GUI class that shows the details of a car.
 *
 * @author Noah Boyd; 5550203507
 * 
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 *
 * Version: 0.1 (July 21st, 2024)
 */
public class CarView extends JFrame {
    // Instance Variables
    private Car car;
    
    /**
     * Constructor for objects of class CarView
     */
    public CarView(Car car) {
        this.car = car;
        
        String title = car.getYear() + " " + car.getMake();
        setTitle(title);
        setSize(500,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(2,1);
        panel.setLayout(layout);
        
        JLabel titleLabel = new JLabel(title);
        panel.add(titleLabel);
        
        JLabel speedLabel = new JLabel(String.valueOf(car.getSpeed()));
        panel.add(speedLabel);
        
        JButton accelerateButton = new JButton("Accelerate");
        panel.add(accelerateButton);
        
        JButton brakeButton = new JButton("Brake");
        panel.add(brakeButton);
        
        // Controller Section
        accelerateButton.addActionListener(new AccelerateButtonListener(car, speedLabel));
        brakeButton.addActionListener(new BrakeButtonListener(car, speedLabel));
        
        
        add(panel);
        pack();
        setVisible(true);
    }

    
}
