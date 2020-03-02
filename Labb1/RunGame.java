public class RunGame {
    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        DrawPanel drawPanel = new DrawPanel(model.getWorldWidth(), model.getWorldHeight());
        CarView frame = new CarView("CarSim 1.0", model.getWorldWidth(), model.getWorldHeight(), drawPanel);
        model.addListeners(frame);
        frame.actOnUpdate();
        CarController cc = new CarController(model, frame);
        // Start a new view and send a reference of self
        // Start the timer
        cc.model.timer.start();
    }
}
