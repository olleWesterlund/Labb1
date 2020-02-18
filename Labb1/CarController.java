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
    ArrayList<VehicleGUI> vehicles = new ArrayList<>();

    //methods:
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new VehicleGUI(VehicleFactory.createVolvo240(), 250, 10));
        cc.vehicles.add(new VehicleGUI(VehicleFactory.createSaab95(), 10, 10));
        cc.vehicles.add(new VehicleGUI(VehicleFactory.createScania(), 500, 10));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.frame.drawPanel.moveIt(cc.vehicles.get(0).getPoint(), cc.vehicles.get(0).getImage());
        cc.frame.drawPanel.moveIt(cc.vehicles.get(1).getPoint(), cc.vehicles.get(1).getImage());
        cc.frame.drawPanel.moveIt(cc.vehicles.get(2).getPoint(), cc.vehicles.get(2).getImage());
        // Start the timer
        cc.timer.start();


    }

    /* Each step the TimerListener moves all the vehicle in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (VehicleGUI vehicle : vehicles) {
                vehicle.getVehicle().move();
                int x = (int) Math.round(vehicle.getVehicle().getX());
                int y = (int) Math.round(vehicle.getVehicle().getY());

                intersectsBottomOrTopWall(vehicle, y);
                intersectsLeftOrRightWall(vehicle, x);
                vehicle.getPoint().x = x;
                vehicle.getPoint().y = y;

                // repaint() calls the paintComponent method of the panel


            }
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each vehicle once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleGUI vehicle : vehicles) {
            if (vehicle.getVehicle().isEngineOn) {
                vehicle.getVehicle().gas(gas);
            } else {
                throw new IllegalArgumentException("Start Engine to use gas");
            }
        }

    }

    void breaks(int amount) {
        double breaks = ((double) amount) / 100;
        for (VehicleGUI vehicle : vehicles) {
            vehicle.getVehicle().brake(breaks);
        }
    }

    void turnLeft() {
        for (VehicleGUI vehicle : vehicles) {
            vehicle.getVehicle().turnLeft();
        }
    }

    void turnRight() {
        for (VehicleGUI vehicle : vehicles) {
            vehicle.getVehicle().turnRight();
        }
    }

    void setTurboOn() {
        for (VehicleGUI vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof Saab95) {
                ((Saab95) vehicle.getVehicle()).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (VehicleGUI vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof Saab95) {
                ((Saab95) vehicle.getVehicle()).setTurboOff();
            }
        }
    }

    void startEngine() {
        for (VehicleGUI vehicle : vehicles) {
            vehicle.getVehicle().startEngine();
        }
    }

    void stopEngine() {
        for (VehicleGUI vehicle : vehicles) {
            vehicle.getVehicle().stopEngine();
        }
    }

    void LiftBed() {
        for (VehicleGUI vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof Truck) {
                ((Truck) vehicle.getVehicle()).setTruckBed();
            }
        }
    }

    void lowerLiftBed() {
        for (VehicleGUI vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof Truck) {
                ((Truck) vehicle.getVehicle()).setTruckBed();
            }
        }
    }

    void addVehicle() {
        //vehicles.add(new VehicleGUI(VehicleFactory.createVolvo240()));
    }

    void intersectsBottomOrTopWall(VehicleGUI vehicle, int y) {

        int topWall = 0;
        int bottomWall = frame.drawPanel.getHeight() - vehicle.getImage().getHeight();
        if (y >= bottomWall) {
            vehicle.getVehicle().setDirection(Direction.DOWN);
            vehicle.getVehicle().startEngine();
        } else if (y <= topWall) {
            vehicle.getVehicle().setDirection(Direction.UP);
            vehicle.getVehicle().startEngine();
        }
    }

    void intersectsLeftOrRightWall(VehicleGUI vehicle, int x) {
        int leftWall = 0;
        int rightWall = frame.drawPanel.getWidth() - vehicle.getImage().getWidth();
        if (x >= rightWall) {
            vehicle.getVehicle().setDirection(Direction.LEFT);
            vehicle.getVehicle().startEngine();
        } else if (x <= leftWall) {
            vehicle.getVehicle().setDirection(Direction.RIGHT);
            vehicle.getVehicle().startEngine();
        }
    }


}
