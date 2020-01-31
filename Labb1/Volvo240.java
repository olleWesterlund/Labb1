import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Constructor for a Volvo240 Object
     */
    public Volvo240() {
        super(4, 100, 0, Color.BLACK,
                "Volvo240", 0, 0, Direction.UP);
    }

    /**
     * @return the speedFactor of the car (enginePower multiplied with 0.01 and trimFactor(1.25))
     */
    @Override
    protected double speedFactor() {
        return super.speedFactor() * trimFactor;
    }
}