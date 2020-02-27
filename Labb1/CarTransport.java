import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransport extends Truck {
    private int maxCars;
    private int loadedCars;
    private Deque<Car> carsOnTransport;

    /**
     * Constructor for CarTransport Object.
     */
    public CarTransport() {
        super(2, 420, 0, 90, Color.PINK,
                "Transporter Deluxe", Direction.UP, 5, 10,
                new TruckBed(0, true, 0, 20));
        this.carsOnTransport = new ArrayDeque<>();
        this.maxCars = 4;
        this.loadedCars = 0;
    }

    /**
     * Overrides method Move() from Vehicle.
     * Uses method updateLoadedCarPositions().
     */
    @Override
    public void move() {
        super.move();
        updateLoadedCarPositions();
    }

    /**
     * Overrides method turnLeft() from Vehicle.
     * Uses method updateLoadedCarPositions().
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        updateLoadedCarPositions();
    }

    /**
     * Overrides method turnRight() from Vehicle.
     * Uses method updateLoadedCarPositions().
     */
    @Override
    public void turnRight() {
        super.turnRight();
        updateLoadedCarPositions();
    }

    /**
     * Sets the values of x and y of the Cars on the CarTransport to the same values as the CarTransport
     * while it's moving.
     */
    protected void updateLoadedCarPositions() {
        for (Car c : carsOnTransport) {
            c.setY(getY());
            c.setX(getX());
        }
    }

    /**
     * Checks if the CarTransport is ready to be unloaded,
     * then unloads the Cars from the CarTransport and puts them beside each other.
     */
    protected void unloadCars() {
        if (isReadyToUnloadCars()) {
            double x = getX() + 1;
            while (!carsOnTransport.isEmpty()) {
                Car firstCar = carsOnTransport.getFirst();
                carsOnTransport.pop();
                firstCar.setY(getY() - 1);
                firstCar.setX(x);
                x++;
            }
        } else {
            throw new IllegalArgumentException("Car transport not ready to unload cars!");
        }
    }

    /**
     * Checks if the CarTransport is ready to be loaded, then loads it.
     *
     * @param car The Car we want to load to the CarTransport.
     */
    protected void loadCars(Car car) {
        if (isReadyToLoadCars() && isCarCloseToTruck(car)) {
            carsOnTransport.push(car);
            loadedCars++;
            carsOnTransport.getFirst().setY(getY());
            carsOnTransport.getFirst().setX(getX());
        } else if (!isReadyToLoadCars()) {
            throw new IllegalArgumentException("Car transport not ready to load cars!");
        } else {
            throw new IllegalArgumentException("Car not close enough to the car transport!");
        }
    }

    /**
     * Checks if the CarTransport is ready to load Cars.
     *
     * @return true or false depending on if it's ready or not.
     */
    protected boolean isReadyToLoadCars() {
        return currentSpeed == 0 && loadedCars < maxCars && !getTruckBed().isReadyToDrive();
    }

    /**
     * Checks if the CarTransport is ready to unload Cars.
     *
     * @return true or false depending on if it's ready or not.
     */
    protected boolean isReadyToUnloadCars() {
        return currentSpeed == 0 && !getTruckBed().isReadyToDrive();
    }

    /**
     * Checks if the Car is close enough to the CarTransport to be loaded.
     *
     * @param car the Car we want to check with the CarTransport.
     * @return true or false depending on if the car is close enough to the CarTransport.
     */
    protected boolean isCarCloseToTruck(Car car) {
        return getX() - car.getX() <= 3 && getY() - car.getY() <= 3;
    }

    /**
     * @return the stack of Cars on the CarTransport.
     */
    protected Deque<Car> getCarsOnTransport() {
        return carsOnTransport;
    }
}
