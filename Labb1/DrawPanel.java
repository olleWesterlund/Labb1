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

    // Just a single image, TODO: Generalize

    List<BufferedImage> vehicleImage = new ArrayList<>();
    // To keep track of a single cars position
    List<Point> vehiclePoint = new ArrayList<>();

    // TODO: Make this general for all cars
    void moveIt(Point point, BufferedImage image) {
        this.vehiclePoint.add(point);
        this.vehicleImage.add(image);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        // Print an error message in case file is not found with a try/catch block


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < vehicleImage.size(); i++) {
            g.drawImage(vehicleImage.get(i), (int) vehiclePoint.get(i).getX(), (int) vehiclePoint.get(i).getY(), null);
        }
    }
}
