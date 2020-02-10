import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {
    private int maxNrOfCars;
    protected List<T> carsInWorkshop = new ArrayList<T>();

    public Workshop(int maxNrOfCars) {
        this.maxNrOfCars = maxNrOfCars;

    }

    public void putCarInWorkshop(T car) {
        if (carsInWorkshop.size() < maxNrOfCars) {
            carsInWorkshop.add(car);
        } else {
            throw new IllegalArgumentException("Workshop is full");
        }
    }

    public void getCarFromWorkshop(T car) {
        carsInWorkshop.remove(car);
    }



}
