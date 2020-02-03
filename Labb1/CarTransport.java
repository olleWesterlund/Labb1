import java.awt.*;

public class CarTransport extends Truck {
    private int maxDegree = 40;
    private int minDegree = 0;

    public CarTransport() {
        super(2, 600, 0, Color.PINK, "Transporter Deluxe", Direction.UP, 5, 10);
    }

    public void setTruckBed() {
        if (getCurrentDegree() == maxDegree) {
            while (getCurrentDegree() > minDegree) {
                truckBedDown();
            }
        } else {
            while (getCurrentDegree() < maxDegree) {
                truckBedUp();
            }
        }
    }

    @Override
    public void truckBedUp() {
        if (getCurrentSpeed() == 0) {
            setCurrentDegree(getCurrentDegree() + 1);
        } else {
            throw new IllegalArgumentException("Can't move truck bed while driving");
        }
    }

    @Override
    public void truckBedDown() {
        setCurrentDegree(getCurrentDegree() - 1);
    }
}
