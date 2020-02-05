import java.awt.*;

/**
 * @Date 31.01.2020
 * @Author Daníel Jónmundsson
 * @Author Tobias Engblom
 * @Author Olle Westerlund
 */

public abstract class Car extends MotorizedVehicles {
    private int nrDoors; // Number of doors on the vehicle

    /**
     * @param nrDoors Number of doors on the car as an Integer
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName
            , Direction direction, double xPosition, double yPosition) {
        super(enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
        this.nrDoors = nrDoors;
        stopEngine();
    }

    /**
     * Speeds up the car with some value by calling incrementSpeed,
     * amount must be bigger or equal to 0 and less or equal to one
     *
     * @param amount holds how much to increase the speed by a double
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            this.incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas only takes a value between [0.1]");
        }
    }

    /**
     * Slows the car with some value, by calling decrementSpeed,
     * amount must be bigger or equal to 0 and less or equal to 1
     *
     * @param amount holds how much to decrease the speed of the car by a double
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            this.decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Brake only takes a value between [0.1]");
        }
    }

    /**
     * Increases the speed of the car by some amount
     *
     * @param amount holds how much to increase the speed in double
     */
    protected void incrementSpeed(double amount) {
        double speed = getCurrentSpeed();
        setCurrentSpeed(Math.max(getCurrentSpeed() + speedFactor() * amount, 0));
        if (speed > getCurrentSpeed()) {
            throw new IllegalArgumentException("Speed did not increase");
        }
    }

    /**
     * Decreases the speed of a car by amount
     *
     * @param amount holds how much to decrease the speed in double
     */
    protected void decrementSpeed(double amount) {
        double speed = getCurrentSpeed();
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        if (speed < getCurrentSpeed()) {
            throw new IllegalArgumentException("Speed did not decrease");
        }
    }

    /**
     * @return the speedFactor for a car
     */
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
