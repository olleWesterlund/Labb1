import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarModel extends JComponent {
    private static final int worldWidth = 1000;
    private static final int worldHeight = 460;
    Random random = new Random();
    // A list of vehicles, modify if needed
    ArrayList<VehicleGUI> vehicles = new ArrayList<>();
    int lastVehicle = vehicles.size() - 1;
    private List<AnimateListener> listeners = new ArrayList<>();
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

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
                // repaint() calls the paintComponent method of the panel
            }
            notifyListeners();
        }
    }


    void intersectsBottomOrTopWall(VehicleGUI vehicle, int y) {
        int topWall = 0;
        int bottomWall = worldHeight - vehicle.getImage().getHeight();
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
        int rightWall = worldWidth - vehicle.getImage().getWidth();
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

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (VehicleGUI vehicle : vehicles) {
            vehicle.getVehicle().brake(brake);
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
        int rand = random.nextInt(4) + 1;
        if (vehicles.size() < 10) {
            switch (rand) {
                case 1:
                    vehicles.add(new VehicleGUI(VehicleFactory.createSaab95(), 10, 10));
                    break;
                case 2:
                    vehicles.add(new VehicleGUI(VehicleFactory.createVolvo240(), 10, 10));
                    break;
                case 3:
                    vehicles.add(new VehicleGUI(VehicleFactory.createScania(), 10, 10));
                    break;
                case 4:
                    vehicles.add(new VehicleGUI(VehicleFactory.createCarTransport(), 10, 10));
                default:
                    break;
            }
            lastVehicle++;
        }
    }

    void removeVehicle() {
        if (vehicles.size() > 0) {
            vehicles.remove(lastVehicle);
        }
    }

    private void notifyListeners() {
        for (AnimateListener l : listeners) {
            l.actOnUpdate();
        }
    }

    public void addListeners(AnimateListener l) {
        listeners.add(l);
    }

    public static int getWorldWidth() {
        return worldWidth;
    }

    public static int getWorldHeight() {
        return worldHeight;
    }

    public int getLastVehicle() {
        return lastVehicle;
    }
}
