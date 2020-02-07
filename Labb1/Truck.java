import java.awt.*;

public abstract class Truck extends MotorizedVehicles {
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
}
