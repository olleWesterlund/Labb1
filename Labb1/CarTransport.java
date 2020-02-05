import java.awt.*;

public class CarTransport extends Truck {
    private int maxCars = 4;
    private int loadedCars = 0;
    private TruckBed truckBed;

    public CarTransport() {
        super(2, 420, 0, Color.PINK, "Transporter Deluxe", Direction.UP, 5, 10);
        this.truckBed = new TruckBed(-70, true, -70, 40);
    }
}
