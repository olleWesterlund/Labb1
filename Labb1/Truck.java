import java.awt.*;

public abstract class Truck extends Vehicle implements TruckBed {
    private int currentDegree; // Current degree of the truck bed

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName,
                 Direction direction, double xPosition, double yPosition) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
        this.currentDegree = 0;
        stopEngine();
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
