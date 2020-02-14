import java.awt.*;

/**
 * @Date 31.01.2020
 * @Author Daníel Jónmundsson
 * @Author Tobias Engblom
 * @Author Olle Westerlund
 */

public abstract class Car extends MotorizedVehicle {
    private int nrDoors; // Number of doors on the vehicle

    /**
     * @param nrDoors Number of doors on the car as an Integer.
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName
            , Direction direction, double xPosition, double yPosition) {
        super(enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
        this.nrDoors = nrDoors;
        stopEngine();
    }


    public int getNrDoors() {
        return nrDoors;
    }
}
