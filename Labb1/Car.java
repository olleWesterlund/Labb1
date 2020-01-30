import java.awt.*;

public class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction direction;
    private double xPosition;
    private double yPosition;


    public Car(int nrDoors, double enginePower, double currentSpeed, Color color,
               String modelName, double xPosition, int yPosition) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = Direction.UP;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public enum Direction {
        LEFT, Right, UP, DOWN
    }

    @Override
    public void Move() {
        Direction dir = getDirection();
        if (dir == Direction.UP) {
            setY(getY() + currentSpeed);
        } else if (dir == Direction.Right) {
            setX(getX() + currentSpeed);
        } else if (dir == Direction.DOWN) {
            setY(getY() - currentSpeed);
        } else if (dir == Direction.LEFT) {
            setX(getX() - currentSpeed);
        }
    }

    @Override
    public void turnRight() {
        Direction dir = getDirection();
        if (dir == Direction.UP) {
            setDirection(Direction.Right);
        } else if (dir == Direction.Right) {
            setDirection(Direction.DOWN);
        } else if (dir == Direction.DOWN) {
            setDirection(Direction.LEFT);
        } else if (dir == Direction.LEFT){
            setDirection(Direction.UP);
        }
    }

    @Override
    public void turnLeft() {
        Direction dir = getDirection();
        if (dir == Direction.UP) {
            setDirection(Direction.LEFT);
        } else if (dir == Direction.LEFT) {
            setDirection(Direction.DOWN);
        } else if (dir == Direction.DOWN) {
            setDirection(Direction.Right);
        } else if (dir == Direction.Right) {
            setDirection(Direction.UP);
        }
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            this.incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas only takes a value between [0,1]");
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            this.decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Brake only takes a value between [0,1]");
        }
    }

    protected void incrementSpeed(double amount) {
        double speed = getCurrentSpeed();
        setCurrentSpeed (Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        if (speed > getCurrentSpeed()) {
            throw new IllegalArgumentException("Speed did not increase");
        }
    }

    protected void decrementSpeed(double amount) {
        double speed = getCurrentSpeed();
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        if (speed < getCurrentSpeed()) {
            throw new IllegalArgumentException("Speed did not decrease");
        }
    }

    protected double speedFactor() {
        return this.speedFactor();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public double getX() {
        return xPosition;
    }

    public double getY() {
        return yPosition;
    }

    protected void setX(double x) {
        this.xPosition = x;
    }

    protected void setY(double y) {
        this.yPosition = y;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    double getEnginePower() {
        return enginePower;
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    protected void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

}
