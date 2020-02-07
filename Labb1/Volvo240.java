import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Constructor for a Volvo240 Object
     */
    public Volvo240() {
        super(4, 100, 0, Color.BLACK,
                "Volvo240", Direction.UP, 0, 0);
    }

    /**
     * SpeedFactor increases the speed of the Volvo by the trimFactor
     *
     * @return the speedFactor method from Car multiplied by the trimFactor of the Volvo
     */
    @Override
    protected double speedFactor() {
        return super.speedFactor() * trimFactor;
    }
}