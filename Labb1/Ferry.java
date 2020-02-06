import java.awt.*;

public class Ferry extends MotorizedVehicles {
    private TruckBed truckBed;

    public Ferry() {
        super(200, 0, Color.YELLOW, "Björn Ferry",
                Direction.UP, 10, 20);
        this.truckBed = new TruckBed(-20, true, -20, 0);
    }
    

}
