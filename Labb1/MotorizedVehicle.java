import java.awt.*;

public abstract class MotorizedVehicle implements Movable {
    private double enginePower;
    protected double currentSpeed;
    private Color color;
    private String modelName;
    private Direction direction;
    private double xPosition;
    private double yPosition;

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
    public MotorizedVehicle(double enginePower, double currentSpeed, Color color, String modelName, Direction direction, double xPosition, double yPosition) {
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * Moves the vehicle with currentSpeed, if the direction of the vehicle is UP or RIGHT
     * then plus the currentSpeed, for LEFT and DOWN, currentSpeed is subtracted.
     */
    @Override
    public void move() {
        Direction dir = getDirection();
        if (dir == Direction.UP) {
            setY(getY() + currentSpeed);
        } else if (dir == Direction.RIGHT) {
            setX(getX() + currentSpeed);
        } else if (dir == Direction.DOWN) {
            setY(getY() - currentSpeed);
        } else if (dir == Direction.LEFT) {
            setX(getX() - currentSpeed);
        }
    }

    /**
     * Handles what directions to turn the vehicle of turnLeft is applied to a vehicle.
     * ex. if vehicle direction is RIGHT and turnLeft is applied, the vehicle will have
     * a new direction UP.
     */
    @Override
    public void turnLeft() {
        Direction dir = getDirection();
        if (dir == (Direction.UP)) {
            setDirection(Direction.LEFT);
        } else if (dir == (Direction.LEFT)) {
            setDirection(Direction.DOWN);
        } else if (dir == (Direction.DOWN)) {
            setDirection(Direction.RIGHT);
        } else if (dir == (Direction.RIGHT)) {
            setDirection(Direction.UP);
        }
    }

    /**
     * Handles what directions to turn the vehicle when turnRight is applied to a vehicle.
     * ex. if vehicle direction is LEFT and turnRight is applied, the vehicle will have
     * a new direction UP.
     */
    @Override
    public void turnRight() {
        Direction dir = getDirection();
        if (dir == Direction.UP) {
            setDirection(Direction.RIGHT);
        } else if (dir == Direction.RIGHT) {
            setDirection(Direction.DOWN);
        } else if (dir == Direction.DOWN) {
            setDirection(Direction.LEFT);
        } else if (dir == Direction.LEFT) {
            setDirection(Direction.UP);
        }
    }

    /**
     * @return the current direction of the vehicle.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return x for the position of a vehicle on the X-axis.
     */
    public double getX() {
        return xPosition;
    }

    /**
     * @return y for the position of a vehicle on the Y-axis.
     */
    public double getY() {
        return yPosition;
    }

    /**
     * Sets a new value for xPosition.
     *
     * @param x double holds the new xPosition of a vehicle on the X-axis.
     */
    protected void setX(double x) {
        this.xPosition = x;
    }

    /**
     * Sets a new value for yPosition.
     *
     * @param y double holds the new yPosition of a vehicle on the Y-Axis.
     */
    protected void setY(double y) {
        this.yPosition = y;
    }

    /**
     * @return the current speed of the vehicle as a double.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return the color of the vehicle.
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the model name of the Vehicle.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * changes the current direction of the vehicle.
     *
     * @param direction Holds a Direction for a vehicle.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * changes the current speed of the vehicle.
     *
     * @param newSpeed holds the new speed as a double.
     */
    protected void setCurrentSpeed(double newSpeed) {
        if (newSpeed > enginePower) {
            this.currentSpeed = enginePower;
        } else if (newSpeed < 0) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = newSpeed;
        }
    }

    /**
     * @return returns the power of the engine as a double.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Starts the engine and sets the speed to 0.1.
     */
    protected void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine and sets the currentSpeed to 0.
     */
    protected void stopEngine() {
        currentSpeed = 0;
    }
}
