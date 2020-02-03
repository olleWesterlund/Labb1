import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    /**
     * Constructor for a Saab95 object
     */
    public Saab95() {
        super(2, 125, 0, Color.red,
                "Saab95", Direction.UP, 1, 1);
        turboOn = false;
    }

    /**
     * sets the turbo for a Saab95 object on
     */
    protected void setTurboOn() {
        turboOn = true;
    }

    /**
     * sets the turbo for a Saab95 object off
     */
    protected void setTurboOff() {
        turboOn = false;
    }

    /**
     * Checks if turbo is on for Saab95, returns true if turbo is on
     *
     * @return true if the turbo is on, false if turbo is off
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * SpeedFactor increses the speed of Saab95 by the turbo but only if its on
     *
     * @return the EnginePower of Saab95 with turbo on
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return super.speedFactor() * turbo;
    }
}
