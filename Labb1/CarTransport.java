import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransport extends Truck {
    private VehicleMovers<Car> transport;

    /**
     * Constructor for CarTransport Object.
     */
    public CarTransport() {
        super(2, 420, 0, 90, Color.PINK,
                "Transporter Deluxe", Direction.UP, 5, 10,
                new TruckBed(0, true, 0, 20));
        transport = new VehicleMovers<>(4, 0);
    }

    protected void unloadCar() {
        if (isReadyToUnloadCars()) {
            double xPos = getxPosition() + 1;
            double yPos = getyPosition();
            while (!transport.getVehicleOnTransport().isEmpty()) {
                transport.unloadVehicle(xPos, yPos);
                xPos++;
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
    protected void loadCar(Car car) {
        if (isReadyToLoadCars() && isCarCloseToTruck(car)) {
            transport.loadVehicle(getxPosition(), getyPosition(), car);
        } else if (!isReadyToLoadCars()) {
            throw new IllegalArgumentException("Car transport not ready to load cars!");
        } else {
            throw new IllegalArgumentException("Car not close enough to the car transport!");
        }
    }

    /**
     * Overrides method Move() from Vehicle.
     * Uses method updateLoadedCarPositions().
     */
    @Override
    public void move() {
        super.move();
        transport.updateVehiclePosition(getxPosition(), getyPosition());
    }

    /**
     * Overrides method turnLeft() from Vehicle.
     * Uses method updateLoadedCarPositions().
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        transport.updateVehiclePosition(getxPosition(), getyPosition());
    }

    /**
     * Overrides method turnRight() from Vehicle.
     * Uses method updateLoadedCarPositions().
     */
    @Override
    public void turnRight() {
        super.turnRight();
        transport.updateVehiclePosition(getxPosition(), getyPosition());
    }

    /**
     * Checks if the CarTransport is ready to unload Cars.
     *
     * @return true or false depending on if it's ready or not.
     */
    protected boolean isReadyToUnloadCars() {
        return getCurrentSpeed() == 0 && !getTruckBed().isReadyToDrive();
    }

    /**
     * Checks if the CarTransport is ready to load Cars.
     *
     * @return true or false depending on if it's ready or not.
     */
    protected boolean isReadyToLoadCars() {
        return getCurrentSpeed() == 0 && !getTruckBed().isReadyToDrive();
    }

    /**
     * Checks if the Car is close enough to the CarTransport to be loaded.
     *
     * @param car the Car we want to check with the CarTransport.
     * @return true or false depending on if the car is close enough to the CarTransport.
     */
    protected boolean isCarCloseToTruck(Car car) {
        return getxPosition() - car.getxPosition() <= 3 && getyPosition() - car.getyPosition() <= 3;
    }

    public VehicleMovers<Car> getTransport() {
        return transport;
    }
}
