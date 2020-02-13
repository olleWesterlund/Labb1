import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {
    private final int maxNrOfCars;
    protected List<T> carsInWorkshop;

    /**
     * Constructor for a workshop.
     *
     * @param maxNrOfCars Maximum number of cars a workshop can handle at the same time.
     */
    public Workshop(int maxNrOfCars) {
        this.maxNrOfCars = maxNrOfCars;
        carsInWorkshop = new ArrayList<T>();
    }

    /**
     * Places the car in the workshop.
     *
     * @param car The Car we want to put in the workshop.
     */
    public void putCarInWorkshop(T car) {
        if (carsInWorkshop.size() >= maxNrOfCars) {
            throw new IllegalArgumentException("Workshop is full, come back another time!");
        } else {
            carsInWorkshop.add(car);
        }
    }

    /**
     * Get's a specific car from the workshop.
     *
     * @param car The car we want to get from the workshop.
     */
    public void getCarFromWorkshop(T car) {
        if (carsInWorkshop.size() > 0) {
            carsInWorkshop.remove(car);
        } else {
            throw new IllegalArgumentException("Workshop is empty");
        }
    }

    /**
     * @return maximum number of cars for the current workshop.
     */
    public int getMaxNrOfCars() {
        return maxNrOfCars;
    }
}
