import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements AnimateListener {
    DrawPanel drawPanel;

    public CarView(String frameName, int frameWidth, int frameHeight, DrawPanel drawPanel) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(30, 30, 1000, 700);
        setVisible(true);
        this.drawPanel = drawPanel;
        initComponents(frameName, frameWidth, frameHeight);
    }

    @Override
    public void actOnUpdate() {
        repaint();
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
    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");
    JButton scaniaTruckBed = new JButton("Truck Bed");
    JButton transportRamp = new JButton("Ramp");
    JButton addVehicleButton = new JButton("Add vehicle");
    JButton removeVehicleButton = new JButton("Remove vehicle");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title, int frameWidth, int frameHeight) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(frameWidth, frameHeight + 240));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

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
        this.add(controlWheelPanel);

        controlPanel.setLayout(new GridLayout(2, 6));
        controlPanel.add(gasButton, 0);
        controlPanel.add(brakeButton, 1);
        controlPanel.add(turboOffButton, 2);
        controlPanel.add(turboOnButton, 3);
        controlPanel.add(scaniaTruckBed, 4);
        controlPanel.add(transportRamp, 5);
        controlPanel.add(turnLeft, 6);
        controlPanel.add(turnRight, 7);
        controlPanel.add(addVehicleButton, 8);
        controlPanel.add(removeVehicleButton, 9);
        controlPanel.setPreferredSize(new Dimension((frameWidth / 2) + 50, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(frameWidth / 8 - 15, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(frameWidth / 8 - 15, 200));

        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}