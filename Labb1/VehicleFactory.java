public abstract class VehicleFactory {

    public static MotorizedVehicle createSaab95() {
        return new Saab95();
    }

    public static MotorizedVehicle createVolvo240() {
        return new Volvo240();
    }

    public static MotorizedVehicle createScania() {
        return new Scania();
    }

    public static MotorizedVehicle createCarTransport() {
        return new CarTransport();
    }
}
