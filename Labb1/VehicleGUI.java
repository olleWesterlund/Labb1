import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VehicleGUI {
    private MotorizedVehicle vehicle;
    private Point point = new Point();
    private BufferedImage image;

    public VehicleGUI(MotorizedVehicle vehicle, int x, int y) {
        this.vehicle = vehicle;
        image = addImageToVehicle(vehicle);
        vehicle.setX(x);
        vehicle.setY(y);

        this.point.x = x;
        this.point.y = y;

    }

    public BufferedImage addImageToVehicle(MotorizedVehicle vehicle) {
        try {
            if (vehicle instanceof Volvo240) {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } else if (vehicle instanceof Saab95) {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            } else if (vehicle instanceof Scania) {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }

    public MotorizedVehicle getVehicle() {
        return vehicle;
    }

    public Point getPoint() {
        return point;
    }

    public BufferedImage getImage() {
        return image;
    }
}
