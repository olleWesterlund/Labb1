import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransport extends Truck {
    private int maxCars = 4;
    private int loadedCars = 0;
    private TruckBed truckBed;
    private Deque<Car> carsOnTransport;

    public CarTransport() {
        super(2, 420, 0, 90, Color.PINK, "Transporter Deluxe", Direction.UP, 5, 10);
        this.truckBed = new TruckBed(0, true, 0, 20);
        this.carsOnTransport = new ArrayDeque<>();
    }

    @Override
    public void move() {
        super.move();
        updateLoadedCarPositions();
    }

    @Override
    public void turnLeft() {
        super.turnLeft();
        updateLoadedCarPositions();
    }

    @Override
    public void turnRight() {
        super.turnRight();
        updateLoadedCarPositions();
    }

    public void updateLoadedCarPositions() {
        for (Car c : carsOnTransport) {
            while (currentSpeed != 0) {
                c.setY(getY());
                c.setX(getX());
            }
        }
    }

    public void unloadCars() {
        if (isReadyToUnloadCars()) {
            Car firstCar = carsOnTransport.getFirst();
            carsOnTransport.pop();
            firstCar.setY(getY() - 3);
            firstCar.setX(getX() - 3);
        } else {
            throw new IllegalArgumentException("Car transport not ready to unload cars!");
        }
    }

    public void loadCars(Car car) {
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

    public boolean isReadyToLoadCars() {
        return currentSpeed == 0 && loadedCars < maxCars && !truckBed.isReadyToDrive();
    }

    public boolean isReadyToUnloadCars() {
        return currentSpeed == 0 && !truckBed.isReadyToDrive();
    }

    public boolean isCarCloseToTruck(Car car) {
        return getX() - car.getX() <= 3 && getY() - car.getY() <= 3;
    }
}
