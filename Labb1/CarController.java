import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // A list of vehicle, modify if needed
    ArrayList<MotorizedVehicle> vehicles = new ArrayList<>();

    //methods:
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        /*
        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());


         */
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the vehicle in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (MotorizedVehicle vehicle : vehicles) {

                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                if (y < 0) {
                    vehicle.setDirection(Direction.UP);
                } else if (y > frame.drawPanel.getHeight() - frame.drawPanel.volvoImage.getHeight()) {
                    vehicle.setDirection(Direction.DOWN);
                }
                if (x < 0) {
                    vehicle.setDirection(Direction.RIGHT);
                } else if (x > frame.getWidth() - frame.drawPanel.volvoImage.getWidth()) {
                    vehicle.setDirection(Direction.LEFT);
                }
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each vehicle once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void breaks(int amount) {
        double breaks = ((double) amount) / 100;
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.brake(breaks);
        }
    }

    void turnLeft() {
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.turnLeft();
        }
    }

    void turnRight() {
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.turnRight();
        }
    }

    void setTurboOn() {
        for (MotorizedVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (MotorizedVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void startEngine() {
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void LiftBed() {
        for (MotorizedVehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                ((Truck) vehicle).setTruckBed();
            }
        }
    }

    void lowerLiftBed() {
        for (MotorizedVehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                ((Truck) vehicle).setTruckBed();
            }
        }
    }

    void addVehicle() {
        vehicles.add(VehicleFactory.createVolvo240());
    }

}