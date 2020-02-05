import java.awt.*;

public abstract class Vehicle implements Movable {
    private double enginePower; // Engine power of the vehicle
    protected double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The vehicle model name
    private Direction direction; // Direction of the vehicle
    private double xPosition; // Position of the vehicle on X-Axis
    private double yPosition; // Position of the vehicle on Y-Axis

    /**
     * Constructor for a vehicle
     *
     * @param enginePower  Engine power of the car as a Double
     * @param currentSpeed The current speed of the vehicle as a Double
     * @param color        Color of the vehicle
     * @param direction    Starting direction of the vehicle
     * @param modelName    Model name of the vehicle as a String
     * @param xPosition    The position of the vehicle on X-Axis as a Double
     * @param yPosition    The position of the vehicle on Y-Axis as a Double
     */
    public Vehicle(double enginePower, double currentSpeed, Color color, String modelName, Direction direction, double xPosition, double yPosition) {
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
     * then plus the currentSpeed, for LEFT and DOWN, currentSpeed is subtracted
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
     * @return x for the position of a vehicle on the X-axis
     */
    public double getX() {
        return xPosition;
    }

    /**
     * @return y for the position of a vehicle on the Y-axis
     */
    public double getY() {
        return yPosition;
    }

    /**
     * Set a new value for xPosition
     *
     * @param x double holds the new xPosition of a vehicle on the X-axis
     */
    protected void setX(double x) {
        this.xPosition = x;
    }

    /**
     * Changes Y-Coordinate
     *
     * @param y double holds the new yPosition of a vehicle on the Y-Axis
     */
    protected void setY(double y) {
        this.yPosition = y;
    }

    /**
     * @return returns current speed of the vehicle as a double
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return the color of the vehicle
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the name of the model
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param direction Holds a Direction for a vehicle
     * @return the direction of a vehicle
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * changes the current speed of the vehicle
     *
     * @param currentSpeed holds the new currentSpeed as a double
     */
    protected void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed > getEnginePower()) {
            this.currentSpeed = getEnginePower();
        } else if (currentSpeed < 0) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }

    /**
     * @return returns the power of the engine as a double
     */
    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Starts the engine and sets the speed to 0.1
     */
    protected void startEngine() {
        setCurrentSpeed(0.1);
    }

    /**
     * Stops the engine and sets the currentSpeed to 0
     */
    protected void stopEngine() {
        setCurrentSpeed(0);
    }
}
