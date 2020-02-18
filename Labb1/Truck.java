import java.awt.*;

public abstract class Truck extends MotorizedVehicle {
    private int nrDoors;
    private final double maxSpeed;
    private TruckBed truckBed;

    /**
     * Constructor for a Truck Object
     *
     * @param nrDoors  Number of doors on the Truck
     * @param maxSpeed The maximum speed of the Truck
     * @param truckBed The truckBed of the Truck
     */
    public Truck(int nrDoors, double enginePower, double currentSpeed, double maxSpeed, Color color, String modelName,
                 Direction direction, double xPosition, double yPosition, TruckBed truckBed) {
        super(enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
        this.nrDoors = nrDoors;
        this.maxSpeed = maxSpeed;
        this.truckBed = truckBed;
        stopEngine();
    }

    /**
     * @return truckBed for current Truck.
     */
    public TruckBed getTruckBed() {
        return truckBed;
    }

    /**
     * changes the current speed of the truck.
     *
     * @param newSpeed holds the new speed as a double.
     */
    @Override
    protected void setCurrentSpeed(double newSpeed) {
        if (!getTruckBed().isReadyToDrive()) {
            throw new IllegalArgumentException("Can't drive while truck bed is up");
        } else {
            if (newSpeed > maxSpeed) {
                this.currentSpeed = maxSpeed;
            } else if (newSpeed < 0) {
                this.currentSpeed = 0;
            } else {
                this.currentSpeed = newSpeed;
            }
        }
    }

    /**
     * Sets TruckBed to the value of parameter degree if it's in the range of minDegree and maxDegree.
     *
     * @param degree the degree that we want to set the current degree of the TruckBed to.
     */
    public void setTruckBed(int degree) {
        int currentDegree = getTruckBed().getCurrentDegree();
        int minDegree = getTruckBed().getMinDegree();
        int maxDegree = getTruckBed().getMaxDegree();
        if (getCurrentSpeed() == 0) {
            if (degree < minDegree || degree > maxDegree) {
                throw new IllegalArgumentException("degree must be in range [" + minDegree + "," + maxDegree + "]");
            } else {
                if (currentDegree < degree) {
                    while (currentDegree < degree) {
                        getTruckBed().truckBedUp();
                        currentDegree = getTruckBed().getCurrentDegree();
                    }
                    getTruckBed().setReadyToDrive(false);
                } else if (currentDegree > degree) {
                    while (currentDegree > degree) {
                        getTruckBed().truckBedDown();
                        currentDegree = getTruckBed().getCurrentDegree();
                    }
                    if (currentDegree == 0) {
                        getTruckBed().setReadyToDrive(true);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Can't set truck bed while driving");
        }
    }


    /**
     * Sets TruckBed up or down depending on the previous mode.
     */
    public void setTruckBed() {
        int currentDegree = getTruckBed().getCurrentDegree();
        int minDegree = getTruckBed().getMinDegree();
        int maxDegree = getTruckBed().getMaxDegree();
        if (getCurrentSpeed() == 0) {
            if (currentDegree == minDegree) {
                while (currentDegree < maxDegree) {
                    getTruckBed().truckBedUp();
                    currentDegree = getTruckBed().getCurrentDegree();
                }
                getTruckBed().setReadyToDrive(false);
            } else {
                while (currentDegree > minDegree) {
                    getTruckBed().truckBedDown();
                    currentDegree = getTruckBed().getCurrentDegree();
                }
                getTruckBed().setReadyToDrive(true);
            }
        } else {
            throw new IllegalArgumentException("Can't set truck bed while driving");
        }
    }

    @Override
    protected double speedFactor() {
        return super.speedFactor() / 5;
    }
}
