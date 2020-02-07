import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    /**
     * Constructor for a Saab95 object.
     */
    public Saab95() {
        super(2, 125, 0, Color.red,
                "Saab95", Direction.UP, 1, 1);
        turboOn = false;
    }

    /**
     * Sets the turbo on for a Saab95 object.
     */
    protected void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets the turbo off for a Saab95 object.
     */
    protected void setTurboOff() {
        turboOn = false;
    }

    /**
     * Checks if turbo is on for Saab95.
     *
     * @return true if turbo is on, false if turbo is off.
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * SpeedFactor increases the speed of Saab95 by the turbo but only if its on.
     *
     * @return the EnginePower of Saab95 with turbo on.
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return super.speedFactor() * turbo;
    }
}
