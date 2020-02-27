import java.util.ArrayDeque;
import java.util.Deque;

public class VehicleMovers<T extends MotorizedVehicle> {
    private int maxNrOfVehicles;
    private int nrOfLoadedVehicles;
    private Deque<T> vehicleOnTransport;

    public VehicleMovers(int maxNrOfVehicles, int loadedVehicles) {
        this.maxNrOfVehicles = maxNrOfVehicles;
        this.nrOfLoadedVehicles = loadedVehicles;
        this.vehicleOnTransport = new ArrayDeque<>();
    }

    /**
     * Loads a vehicle on the transport and sets the vehicles position to that
     * of the transport.
     *
     * @param x the x position of the transporter.
     * @param y the y position of the transporter.
     */
    protected void unloadVehicle(double x, double y) {
        T firstVehicle = vehicleOnTransport.getFirst();
        vehicleOnTransport.pop();
        firstVehicle.setyPosition(y);
        firstVehicle.setxPosition(x);
    }

    /**
     * Loads the vehicle on the transport.
     *
     * @param vehicle The Vehicle we want to load on the transport.
     */
    protected void loadVehicle(double x, double y, T vehicle) {
        if (nrOfLoadedVehicles < maxNrOfVehicles) {
            vehicleOnTransport.push(vehicle);
            nrOfLoadedVehicles++;
            vehicleOnTransport.getFirst().setyPosition(y);
            vehicleOnTransport.getFirst().setxPosition(x);
        } else {
            throw new IllegalArgumentException("Transport is full");
        }
    }

    protected void updateVehiclePosition(double xPos, double yPos) {
        for (T vehicle : vehicleOnTransport) {
            vehicle.setyPosition(yPos);
            vehicle.setxPosition(xPos);
        }
    }

    public int getMaxNrOfVehicles() {
        return maxNrOfVehicles;
    }

    public int getNrOfLoadedVehicles() {
        return nrOfLoadedVehicles;
    }

    public Deque<T> getVehicleOnTransport() {
        return vehicleOnTransport;
    }
}
