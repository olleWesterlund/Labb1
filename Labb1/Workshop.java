import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {

    private int maxNrOfCars;
    protected List<T> carsInWorkshop = new ArrayList<T>();

    public Workshop(int maxNrOfCars) {
        this.maxNrOfCars = maxNrOfCars;
    }

    public void putCarInWorkshop(T car) {
        if (carsInWorkshop.size() >= maxNrOfCars) {
            throw new IllegalArgumentException("Workshop is full, come back another time!");
        } else {
            carsInWorkshop.add(car);
        }
    }

    public void getCarFromWorkshop(T car) {
        if (carsInWorkshop.size() > 0) {
            carsInWorkshop.remove(car);
        } else {
            throw new IllegalArgumentException("Workshop is empty");
        }
    }

    public int getMaxNrOfCars() {
        return maxNrOfCars;
    }
}
