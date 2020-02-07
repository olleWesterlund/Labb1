import java.awt.*;

/**
 * Constructor for a Scania Object.
 */
public class Scania extends Truck {
    public Scania() {
        super(2, 450, 0, 90, Color.BLUE, "Scania",
                Direction.UP, 20, 10,
                new TruckBed(0, true, 0, 70));
    }
}
