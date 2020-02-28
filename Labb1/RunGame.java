public class RunGame {
    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        CarView frame = new CarView();
        DrawPanel drawPanel = new DrawPanel(model.getFrameWidth(), model.getFrameHeight());
        model.addListeners(frame);
        frame.actOnUpdate();
        CarController cc = new CarController("CarSim 1.0", model, frame, drawPanel);
        // Start a new view and send a reference of self
        // Start the timer
        cc.model.timer.start();
    }
}
