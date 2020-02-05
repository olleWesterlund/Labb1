import java.awt.*;

public class Ferry extends MotorizedVehicles implements MovableTruckBed {
    public Ferry() {
        super(200, 0, Color.YELLOW, "Björn Ferry", Direction.UP, 10, 20);
    }

    @Override
    public void truckBedUp() {

    }

    @Override
    public void truckBedDown() {

    }
}
