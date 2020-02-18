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
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println(vehiclePoint.size());
        //System.out.println(vehiclePoint.get(0).getX());
        g.drawImage(vehicleImage.get(0), (int) vehiclePoint.get(0).getX(), (int) vehiclePoint.get(0).getY(), null);
        g.drawImage(vehicleImage.get(1), (int) vehiclePoint.get(1).getX(), (int) vehiclePoint.get(1).getY(), null);
        g.drawImage(vehicleImage.get(2),(int) vehiclePoint.get(2).getX(), (int) vehiclePoint.get(2).getY(), null);
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        //g.drawImage(saabImage, saabPoint.x + 150, saabPoint.y, null);
        //g.drawImage(scaniaImage, scaniaPoint.x + 300, scaniaPoint.y, null);
    }
}
