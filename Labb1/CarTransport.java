import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransport extends Truck {
    private int maxCars = 4;
    private int loadedCars = 0;
    private Deque<Car> carsOnTransport;

    public CarTransport() {
        super(2, 420, 0, 90, Color.PINK,
                "Transporter Deluxe", Direction.UP, 5, 10,
                new TruckBed(0, true, 0, 20));
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
            c.setY(getY());
            c.setX(getX());
        }
    }

    public void unloadCars() {
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
        return currentSpeed == 0 && loadedCars < maxCars && !getTruckBed().isReadyToDrive();
    }

    public boolean isReadyToUnloadCars() {
        return currentSpeed == 0 && !getTruckBed().isReadyToDrive();
    }

    public boolean isCarCloseToTruck(Car car) {
        return getX() - car.getX() <= 3 && getY() - car.getY() <= 3;
    }

    public Deque<Car> getCarsOnTransport() {
        return carsOnTransport;
    }
}
