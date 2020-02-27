public abstract class Movable implements IMovable {
    private double currentSpeed;
    private double xPosition;
    private double yPosition;
    private Direction direction;

    public Movable(double currentSpeed, double xPosition, double yPosition, Direction direction) {
        this.currentSpeed = currentSpeed;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    protected double getxPosition() {
        return xPosition;
    }

    protected void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    protected double getyPosition() {
        return yPosition;
    }

    protected void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    protected Direction getDirection() {
        return direction;
    }

    protected void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Moves the vehicle with currentSpeed, if the direction of the vehicle is UP or RIGHT
     * then plus the currentSpeed, for LEFT and DOWN, currentSpeed is subtracted.
     */
    @Override
    public void move() {
        Direction dir = getDirection();
        if (dir == Direction.UP) {
            setyPosition(getyPosition() + currentSpeed);
        } else if (dir == Direction.RIGHT) {
            setxPosition(getxPosition() + currentSpeed);
        } else if (dir == Direction.DOWN) {
            setyPosition(getyPosition() - currentSpeed);
        } else if (dir == Direction.LEFT) {
            setxPosition(getxPosition() - currentSpeed);
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

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    protected void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
