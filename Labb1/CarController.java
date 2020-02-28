import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    private CarModel model;

    //methods:
    /* Each step the TimerListener moves all the vehicle in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    public CarController(String frameName, CarView frame, CarModel model) {
        this.frame = frame;
        this.model = model;
        initComponents(frameName);
    }

    JPanel controlPanel = new JPanel();
    JPanel controlWheelPanel = new JPanel();

    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JSpinner degreeSpinner = new JSpinner();
    int degreeAmount = 0;
    JLabel degreeLabel = new JLabel("Amount of degree");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turnLeft = new JButton("Turn left");
    JButton turnRight = new JButton("Turn Right");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");

    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addVehicleButton = new JButton("Add vehicle");
    JButton removeVehicleButton = new JButton("Remove a vehicle");


    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(model.getFrameWidth(), model.getFrameHeight()));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        SpinnerModel spinnerDegreeModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        degreeSpinner = new JSpinner((spinnerDegreeModel));
        degreeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                degreeAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
        controlWheelPanel.setLayout(new GridLayout(2, 2));
        controlWheelPanel.add(gasLabel, 0);
        controlWheelPanel.add(gasSpinner, 1);
        controlWheelPanel.add(degreeLabel, 2);
        controlWheelPanel.add(degreeSpinner, 3);
        frame.add(controlWheelPanel);

        controlPanel.setLayout(new GridLayout(2, 6));
        controlPanel.add(gasButton, 0);
        controlPanel.add(brakeButton, 1);
        controlPanel.add(turboOffButton, 2);
        controlPanel.add(turboOnButton, 3);
        controlPanel.add(liftBedButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(turnLeft, 6);
        controlPanel.add(turnRight, 7);
        controlPanel.add(addVehicleButton, 8);
        controlPanel.add(removeVehicleButton, 9);
        controlPanel.setPreferredSize(new Dimension((model.getFrameWidth() / 2) + 50, 200));
        frame.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(model.getFrameWidth() / 8 - 15, 200));
        frame.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(model.getFrameWidth() / 8 - 15, 200));

        frame.add(stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
            }
        });


        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });

        turnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.turnLeft();
            }
        });

        turnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.turnRight();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.setTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.setTurboOff();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.startEngine();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.stopEngine();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.LiftBed(degreeAmount);
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerLiftBed();
            }
        });

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addVehicle();
            }
        });


        // Make the frame pack all it's components by respecting the sizes if possible.
        frame.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        // Make the frame visible
        frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
