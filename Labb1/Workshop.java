import java.util.List;

public class Workshop <T extends Car>{

    private int maxNrOfCars;
    private List<T> carsInWorkshop;

    public Workshop(int maxNrOfCars) {
        this.maxNrOfCars = maxNrOfCars;
    }

    public void putCarInWorkshop(T car) {

    }

}
