import java.awt.*;

public abstract class Truck extends Vehicle implements TruckBed {
    private int nrDoors; // Number of doors on the vehicle
    private int currentDegree; // Current degree of the truck bed
    private boolean isTruckBedDown;

    /**
     * @param nrDoors Number of doors on the car as an Integer
     */
    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName,
                 Direction direction, double xPosition, double yPosition) {
        super(enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
        this.currentDegree = 0;
        this.isTruckBedDown = false;
        this.nrDoors = nrDoors;
        stopEngine();
    }

    public boolean isTruckBedDown() {
        return isTruckBedDown;
    }

    public void setTruckBedDown(boolean truckBedDown) {
        isTruckBedDown = truckBedDown;
    }

    public int getCurrentDegree() {
        return currentDegree;
    }

    public void setCurrentDegree(int currentDegree) {
        this.currentDegree = currentDegree;
    }

    /**
     * changes the current speed of the vehicle
     *
     * @param currentSpeed holds the new currentSpeed as a double
     */
    @Override
    protected void setCurrentSpeed(double currentSpeed) {
        if (currentDegree > 0) {
            throw new IllegalArgumentException("Can't drive while truck bed is up");
        }
        if (currentSpeed > getEnginePower()) {
            this.currentSpeed = getEnginePower();
        } else if (currentSpeed < 0) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }
}
