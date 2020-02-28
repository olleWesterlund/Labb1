public class RunGame {
    public static CarModel initVehicles() {
        CarModel vehicles = new CarModel();

        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createVolvo240(), 250, 10));
        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createSaab95(), 10, 10));
        vehicles.addVehicle(new VehicleGUI(VehicleFactory.createScania(), 500, 10));

        return vehicles;
    }

    public static void main(String[] args) {
        // Instance of this class
        CarModel model = initVehicles();
        CarView frame = new CarView();
        DrawPanel drawPanel = new DrawPanel(model.getFrameWidth(), model.getFrameHeight() - 240);
        frame.add(drawPanel);
        CarController cc = new CarController("CarSim 1.0", frame, model);
        frame.add(model);
        frame.actOnUpdate();
        // Start a new view and send a reference of self
        for (int i = 0; i < model.vehicles.size(); i++) {
            drawPanel.moveIt(model.vehicles.get(i).getPoint(), model.vehicles.get(i).getImage());
        }
        // Start the timer
        model.timer.start();
    }
}
