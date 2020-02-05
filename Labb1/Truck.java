import java.awt.*;

public abstract class Truck extends MotorizedVehicles {
    private int nrDoors; // Number of doors on the vehicle
    private int maxSpeed = 90;

    /**
     * @param nrDoors Number of doors on the car as an Integer
     */
    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName,
                 Direction direction, double xPosition, double yPosition) {
        super(enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
        this.nrDoors = nrDoors;
        stopEngine();
    }

    /**
     * changes the current speed of the truck
     *
     * @param newSpeed holds the new speed as a double
     */

    protected void setCurrentSpeed(double newSpeed, TruckBed truckBed) {
        if (!truckBed.isTruckBedMinDegree()) {
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
}
