import java.awt.*;

/**
 * @Date 31.01.2020
 * @Author Daníel Jónmundsson
 * @Author Tobias Engblom
 * @Author Olle Westerlund
 */

public abstract class Car extends Vehicle {
    /**
     * Constructor for a car
     *
     * @param nrDoors      Number of doors on the car as an Integer
     * @param enginePower  Engine power of the car as a Double
     * @param currentSpeed The current speed of the var as a Double
     * @param color        Color of the car
     * @param modelName    Model name of the car as a String
     * @param xPosition    The cars position on X-Axis as a Double
     * @param yPosition    The cars position on Y-Axis as a Double
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Direction direction, double xPosition, double yPosition) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction, xPosition, yPosition);
    }

    /**
     * Moves the car with currentSpeed, if the direction of the car is UP or RIGHT
     * then plus the currentSpeed, for LEFT and DOWN, currentSpeed is subtracted
     */

    /**
     * Handles what directions to turn the car when turnRight is applied to a car.
     * ex. if Car direction is LEFT and turnRight is applied, the car will have
     * a new direction UP.
     */

    /**
     * Handles what directions to turn the car of turnLeft is applied to a car.
     * ex. if Car direction is RIGHT and turnLeft is applied, the car will have
     * a new direction UP.
     */

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

    /**
     * @return the current direction of the car.
     */

    /**
     * @param direction Holds a Direction for a car
     * @return the direction of a car
     */

    /**
     * @return x for the cars position on the X-axis
     */

    /**
     * @return y for the cars position on the Y-axis
     */

    /**
     * Set a new value for xPosition
     *
     * @param x double holds the new xPosition of a car on the X-axis
     */

    /**
     * Changes Y-Coordinate
     *
     * @param y double holds the new yPosition of a car on the Y-Axis
     */

    /**
     * Starts the engine and sets the speed to 0.1
     */

    /**
     * Stops the engine and sets the currentSpeed to 0
     */

    /**
     * @return returns the number of doors as an int
     */

    /**
     * @return returns the power of the engine as a double
     */

    /**
     * @return returns current speed of the car as a double
     */

    /**
     * @return the color of the car
     */

    /**
     * @return the name of the model
     */

    /**
     * changes the current speed of the car
     *
     * @param currentSpeed holds the new currentSpeed as a double
     */
}
