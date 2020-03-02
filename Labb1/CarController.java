import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    CarModel model;
    //methods:

    /* Each step the TimerListener moves all the vehicle in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    public CarController(CarModel model, CarView frame) {
        this.model = model;
        this.frame = frame;
        initComponents();
    }

    // This actionListener is for the gas button only
    // TODO: Create more for each component as necessary
    private void initComponents() {
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.gas(frame.gasAmount);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(frame.gasAmount);
            }
        });

        frame.turnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.turnLeft();
            }
        });

        frame.turnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.turnRight();
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.setTurboOn();
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.setTurboOff();
            }
        });
        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.startEngine();
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.stopEngine();
            }
        });

        frame.scaniaTruckBed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.LiftBed(frame.degreeAmount);
            }
        });

        frame.transportRamp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerLiftBed();
            }
        });

        frame.addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addVehicle();
                int newVehicle = model.vehicles.size() - 1;
                frame.drawPanel.moveIt(model.vehicles.get(newVehicle));
                frame.repaint();
            }
        });

        frame.removeVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.vehicles.size() > 0) {
                    model.removeVehicle();
                    frame.drawPanel.vehicles.remove(model.getLastVehicle());
                    model.lastVehicle--;
                    frame.repaint();
                }
            }
        });
    }
}

