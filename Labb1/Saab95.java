import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    /**
     * Constructor for a Saab95 object
     */
    public Saab95() {
        super(2,125, 0,Color.red,
                "Saab95", 1,1);
        turboOn = false;
    }

    /**
     * sets the turbo on
     */
    protected void setTurboOn() {
        turboOn = true;
    }

    /**
     * sets the turbo off
     */
    protected void setTurboOff() {
        turboOn = false;
    }

    /**
     * Boolean to see if turbo is on
     * @return
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * @return returns the current speed factor for Saab95 which is multiplied with 0.01 and turbo
     * turbo is 1.3 if its on.
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
