import java.awt.*;

public abstract class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The  current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction direction; // Direction of the car
    private double xPosition; // Position of the car on X-Axis
    private double yPosition; // Position of the car on Y-Axis

    public Vehicle(int nrDoors, double enginePower, double currentSpeed,
                   Color color, String modelName, Direction direction, double xPosition, double yPosition) {
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

    public Direction getDirection() {
        return direction;
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

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    protected void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed > getEnginePower()) {
            this.currentSpeed = getEnginePower();
        } else if (currentSpeed < 0) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }

    protected void startEngine() {
        currentSpeed = 0.1;
    }

    protected void stopEngine() {
        currentSpeed = 0;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
