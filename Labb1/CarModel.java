import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private static final int frameWidth = 1000;
    private static final int frameHeight = 700;
    // A list of vehicles, modify if needed
    ArrayList<VehicleGUI> vehicles = new ArrayList<>();
    private List<AnimateListener> listeners = new ArrayList<>();
    List<BufferedImage> vehicleImage = new ArrayList<>();
    // To keep track of a single cars position
    List<Point> vehiclePoint = new ArrayList<>();
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

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
            notifyListeners();
        }
    }


    void intersectsBottomOrTopWall(VehicleGUI vehicle, int y) {
        int topWall = 0;
        int bottomWall = frameHeight - vehicle.getImage().getHeight();
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
        int rightWall = frameWidth - vehicle.getImage().getWidth();
        if (x >= rightWall) {
            vehicle.getVehicle().setDirection(Direction.LEFT);
            vehicle.getVehicle().startEngine();
        } else if (x <= leftWall) {
            vehicle.getVehicle().setDirection(Direction.RIGHT);
            vehicle.getVehicle().startEngine();
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
        //vehicles.add(new VehicleGUI(VehicleFactory.createVolvo240()));
    }

    private void notifyListeners() {
        for (AnimateListener l : listeners) {
            l.actOnUpdate();
        }
    }

    public void addListeners(AnimateListener l) {
        listeners.add(l);
    }

    public void addVehicle(VehicleGUI vehicle) {
        vehicles.add(vehicle);
    }

    public static int getFrameWidth() {
        return frameWidth;
    }

    public static int getFrameHeight() {
        return frameHeight;
    }


    // TODO: Make this general for all cars
    void moveIt(Point point, BufferedImage image) {
        this.vehiclePoint.add(point);
        this.vehicleImage.add(image);
    }
}
