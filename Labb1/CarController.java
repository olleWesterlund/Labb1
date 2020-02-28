import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    Random random = new Random();
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

            for (VehicleGUI vehicle : vehicles) {
                vehicle.getVehicle().move();
                int x = (int) Math.round(vehicle.getVehicle().getxPosition());
                int y = (int) Math.round(vehicle.getVehicle().getyPosition());

                intersectsBottomOrTopWall(vehicle, y);
                intersectsLeftOrRightWall(vehicle, x);
                vehicle.getPoint().x = x;
                vehicle.getPoint().y = y;
            }
            // repaint() calls the paintComponent method of the panel
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
            if (vehicle.getVehicle().getCurrentSpeed() == 0) {
                vehicle.getVehicle().startEngine();
            } else {
                continue;
            }
        }
    }

    void stopEngine() {
        for (VehicleGUI vehicle : vehicles) {
            vehicle.getVehicle().stopEngine();
        }
    }

    void LiftBed(int amount) {
        for (VehicleGUI vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof Scania) {
                ((Truck) vehicle.getVehicle()).setTruckBed(amount);
            }
        }
    }

    void lowerLiftBed() {
        for (VehicleGUI vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof CarTransport) {
                ((Truck) vehicle.getVehicle()).setTruckBed();
            }
        }
    }

    void addVehicle() {
        int x = random.nextInt(3) + 1;
        if (vehicles.size() < 10) {
            switch (x) {
                case 1:
                    vehicles.add(new VehicleGUI(VehicleFactory.createSaab95(), 10, 10));
                    break;
                case 2:
                    vehicles.add(new VehicleGUI(VehicleFactory.createVolvo240(), 10, 10));
                    break;
                case 3:
                    vehicles.add(new VehicleGUI(VehicleFactory.createScania(), 10, 10));
                    break;
                default:
                    break;
            }
            int newVehicle = vehicles.size() - 1;
            frame.drawPanel.moveIt(vehicles.get(newVehicle).getPoint(), vehicles.get(newVehicle).getImage());
            frame.repaint();
        }
    }

    void removeVehicle() {
        if (vehicles.size() > 0) {
            int i = vehicles.size() - 1;
            frame.drawPanel.vehicleImage.remove(i);
            frame.drawPanel.vehiclePoint.remove(i);
            vehicles.remove(i);
            frame.repaint();
        }
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
