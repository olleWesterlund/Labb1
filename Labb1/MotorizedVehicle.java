import java.awt.*;

public abstract class MotorizedVehicle extends Movable {
    private double enginePower;
    private Color color;
    private String modelName;
    protected boolean isEngineOn;

    /**
     * Constructor for a vehicle
     *
     * @param enginePower  Engine power of the vehicle as a Double.
     * @param currentSpeed The current speed of the vehicle as a Double.
     * @param color        Color of the vehicle.
     * @param direction    Starting direction of the vehicle.
     * @param modelName    Model name of the vehicle as a String.
     * @param xPosition    The position of the vehicle on X-Axis as a Double.
     * @param yPosition    The position of the vehicle on Y-Axis as a Double.
     */
    public MotorizedVehicle(double enginePower, double currentSpeed, Color color, String modelName,
                            Direction direction, double xPosition, double yPosition) {
        super(currentSpeed, xPosition, yPosition, direction);
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * Speeds up the car with some value by calling incrementSpeed,
     * amount must be bigger or equal to 0 and less or equal to one.
     *
     * @param amount holds how much to increase the speed by a double.
     */
    protected void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            this.incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas only takes a value between [0-1]");
        }
    }

    /**
     * Slows the car with some value, by calling decrementSpeed,
     * amount must be bigger or equal to 0 and less or equal to 1.
     *
     * @param amount holds how much to decrease the speed of the car by a double.
     */
    protected void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            this.decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Brake only takes a value between [0.1]");
        }
    }

    /**
     * Increases the speed of the car by some amount.
     *
     * @param amount holds how much to increase the speed in double.
     */
    protected void incrementSpeed(double amount) {
        double speed = getCurrentSpeed();
        setCurrentSpeed(Math.max(getCurrentSpeed() + speedFactor() * amount, 0));
        if (speed > getCurrentSpeed()) {
            throw new IllegalArgumentException("Speed did not increase");
        }
    }

    /**
     * Decreases the speed of a car by amount.
     *
     * @param amount holds how much to decrease the speed in double.
     */
    protected void decrementSpeed(double amount) {
        double speed = getCurrentSpeed();
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        if (speed < getCurrentSpeed()) {
            throw new IllegalArgumentException("Speed did not decrease");
        }
    }

    /**
     * @return the speedFactor for a car.
     */
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * @return the color of the vehicle.
     */
    protected Color getColor() {
        return color;
    }

    /**
     * @return the model name of the Vehicle.
     */
    protected String getModelName() {
        return modelName;
    }

    /**
     * changes the current speed of the vehicle.
     *
     * @param newSpeed holds the new speed as a double.
     */
    @Override
    protected void setCurrentSpeed(double newSpeed) {
        if (newSpeed > enginePower) {
            super.setCurrentSpeed(enginePower);
        } else if (newSpeed < 0) {
            super.setCurrentSpeed(0);
        } else {
            super.setCurrentSpeed(newSpeed);
        }
    }

    /**
     * @return returns the power of the engine as a double.
     */
    protected double getEnginePower() {
        return enginePower;
    }

    /**
     * Starts the engine and sets the speed to 0.1.
     */
    protected void startEngine() {
        setCurrentSpeed(0.1);
        isEngineOn = true;
    }

    /**
     * Stops the engine and sets the currentSpeed to 0.
     */
    protected void stopEngine() {
        setCurrentSpeed(0);
        isEngineOn = false;
    }

}
