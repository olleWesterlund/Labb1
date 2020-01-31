import java.awt.*;

/**
 * @Date 31.01.2020
 * @Author Daníel Jónmundsson
 * @Author Tobias Engblom
 * @Author Olle Westerlund
 */

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The  current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction direction; // Direction of the car
    private double xPosition; // Position of the car on X-Axis
    private double yPosition; // Position of the car on Y-Axis

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

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color,
               String modelName, double xPosition, double yPosition, Direction direction) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        stopEngine();
    }

    /**
     * Moves the car with currentSpeed, if the direction of the car is UP or RIGHT
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
     * Handles what directions to turn the car when turnRight is applied to a car.
     * ex. if Car direction is LEFT and turnRight is applied, the car will have
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
     * Handles what directions to turn the car of turnLeft is applied to a car.
     * ex. if Car direction is RIGHT and turnLeft is applied, the car will have
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
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction Holds a Direction for a car
     * @return the direction of a car
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return x for the cars position on the X-axis
     */
    public double getX() {
        return xPosition;
    }

    /**
     * @return y for the cars position on the Y-axis
     */
    public double getY() {
        return yPosition;
    }

    /**
     * Set a new value for xPosition
     *
     * @param x double holds the new xPosition of a car on the X-axis
     */
    protected void setX(double x) {
        this.xPosition = x;
    }

    /**
     * Changes Y-Coordinate
     *
     * @param y double holds the new yPosition of a car on the Y-Axis
     */
    protected void setY(double y) {
        this.yPosition = y;
    }

    /**
     * Starts the engine and sets the speed to 0.1
     */
    protected void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine and sets the currentSpeed to 0
     */
    protected void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * @return returns the number of doors as an int
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * @return returns the power of the engine as a double
     */
    double getEnginePower() {
        return enginePower;
    }

    /**
     * @return returns current speed of the car as a double
     */
    double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return the color of the car
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
     * changes the current speed of the car
     *
     * @param currentSpeed holds the new currentSpeed as a double
     */
    protected void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed > this.getEnginePower()) {
            this.currentSpeed = this.getEnginePower();
        } else if (currentSpeed < 0) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }
}
