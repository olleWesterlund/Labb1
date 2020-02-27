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
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
    }

    public static CarModel initVehicles() {
        CarModel vehicles = new CarModel();

        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createVolvo240(), 250, 10));
        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createSaab95(), 10, 10));
        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createScania(), 500, 10));

        return vehicles;
    }

    public static void main(String[] args) {
        // Instance of this class
        CarView frame = new CarView();
        CarModel model = initVehicles();
        CarController cc = new CarController("CarSim 1.0", frame, model);

        frame.add(model);
        // Start a new view and send a reference of self
        for (int i = 0; i < model.vehicles.size(); i++) {
            frame.drawPanel.moveIt(model.vehicles.get(i).getPoint(), model.vehicles.get(i).getImage());
        }
        // Start the timer
        model.timer.start();
    }
}
