import java.awt.*;

public class Scania extends Truck {
    public TruckBed truckBed;

    public Scania() {
        super(2, 450, 0, 90, Color.BLUE, "Scania",
                Direction.UP, 20, 10);
        this.truckBed = new TruckBed(0, true, 0, 70);
    }
}
