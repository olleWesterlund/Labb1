import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95",1,1);
	    turboOn = false;
        stopEngine();
    }

    protected void setTurboOn(){
	    turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
