import java.awt.*;

public class Truck implements Movable {

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private Direction direction;
    private double xPosition;
    private double yPosition;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color,
                 String modelName, Direction direction, int xPosition, int yPosition) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public enum Direction {
        RIGHT, LEFT, UP, DOWN
    }


    @Override
    public void move() {
        Truck.Direction dir = getDirection();
        if (dir == Truck.Direction.UP) {
            setyPosition(getyPosition() + currentSpeed);
        } else if (dir == Truck.Direction.RIGHT) {
            setxPosition(getxPosition() + currentSpeed);
        } else if (dir == Truck.Direction.DOWN) {
            setyPosition(getyPosition() - currentSpeed);
        } else if (dir == Truck.Direction.LEFT) {
            setyPosition(getyPosition() - currentSpeed);
        }
    }

    @Override
    public void turnLeft() {
        Truck.Direction dir = getDirection();
        if (dir == (Truck.Direction.UP)) {
            setDirection(Truck.Direction.LEFT);
        } else if (dir == (Truck.Direction.LEFT)) {
            setDirection(Truck.Direction.DOWN);
        } else if (dir == (Truck.Direction.DOWN)) {
            setDirection(Truck.Direction.RIGHT);
        } else if (dir == (Truck.Direction.RIGHT)) {
            setDirection(Truck.Direction.UP);
        }

    }

    @Override
    public void turnRight() {
        Truck.Direction dir = getDirection();
        if (dir == Truck.Direction.UP) {
            setDirection(Truck.Direction.RIGHT);
        } else if (dir == Truck.Direction.RIGHT) {
            setDirection(Truck.Direction.DOWN);
        } else if (dir == Truck.Direction.DOWN) {
            setDirection(Truck.Direction.LEFT);
        } else if (dir == Truck.Direction.LEFT) {
            setDirection(Truck.Direction.UP);
        }
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

    public Direction getDirection() {
        return direction;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }
}
