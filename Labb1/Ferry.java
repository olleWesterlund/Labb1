import java.awt.*;

public class Ferry extends MotorizedVehicles implements MovableTruckBed {

    /**
     * Constructor for a Ferry
     *
     * @param enginePower  Engine power of the ferry as a Double
     * @param currentSpeed The current speed of the ferry as a Double
     * @param color        Color of the ferry
     * @param modelName    Model name of the ferry as a String
     * @param direction    Starting direction of the ferry
     * @param xPosition    The position of the ferry on X-Axis as a Double
     * @param yPosition    The position of the ferry on Y-Axis as a Double
     */
    public Ferry(double enginePower, double currentSpeed, Color color, String modelName, Direction direction, double xPosition, double yPosition) {
        super(enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
    }

    @Override
    public void truckBedUp() {

    }

    @Override
    public void truckBedDown() {

    }
}
