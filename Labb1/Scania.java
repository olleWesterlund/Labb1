import java.awt.*;

public class Scania extends Truck {
    private int maxDegree;
    private int minDegree;

    public Scania() {
        super(2, 450, 0, Color.BLUE, "Scania",
                Direction.UP, 20, 10);
    }

    public void setTruckBed(int degree) {
        if (degree < minDegree || degree > maxDegree) {
            throw new IllegalArgumentException("degree must be in range [0,70]");
        } else {
            if (getCurrentDegree() < degree) {
                while (getCurrentDegree() < degree) {
                    truckBedUp();
                }
            } else if (getCurrentDegree() > degree) {
                while (getCurrentDegree() > degree) {
                    truckBedDown();
                }
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
