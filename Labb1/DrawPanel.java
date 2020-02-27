import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    public static CarModel initVehicles() {
        CarModel vehicles = new CarModel();

        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createVolvo240(), 250, 10));
        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createSaab95(), 10, 10));
        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createScania(), 500, 10));

        return vehicles;
    }

    public static void main(String[] args) {
        // Instance of this class
        CarModel model = initVehicles();
        CarView frame = new CarView(model.getFrameWidth(), model.getFrameHeight());
        CarController cc = new CarController("CarSim 1.0", frame, model);

        frame.add(model);
        // Start a new view and send a reference of self
        for (int i = 0; i < model.vehicles.size(); i++) {
            model.moveIt(model.vehicles.get(i).getPoint(), model.vehicles.get(i).getImage());
        }
        // Start the timer
        model.timer.start();
    }
}
