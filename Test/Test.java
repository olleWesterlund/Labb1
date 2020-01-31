import org.junit.Assert;
import org.junit.Before;

import java.awt.*;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class Test {
    private Saab95 saab95;
    private Volvo240 volvo240;

    @Before
    public void init() {
        saab95 = new Saab95();
        volvo240 = new Volvo240();
    }


    @org.junit.Test
    public void testSaab95TurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.isTurboOn());
    }

    @org.junit.Test
    public void testSaab95TurboOff() {
        saab95.setTurboOff();
        assertTrue(!saab95.isTurboOn());
    }

    @org.junit.Test
    public void testSaab95SpeedFactorWithTurbo() {
        saab95.setTurboOn();
        assertTrue(saab95.speedFactor() ==
                saab95.getEnginePower() * 0.01 * 1.3);
    }


    @org.junit.Test
    public void testSaab96SpeedFactorNoTurbo() {
        saab95.setTurboOff();
        assertTrue(saab95.speedFactor() ==
                saab95.getEnginePower() * 0.01);
    }

    @org.junit.Test
    public void testSaab95IncrementSpeed() {
        double startSpeed = saab95.getCurrentSpeed();
        saab95.incrementSpeed(1);
        assertTrue(startSpeed < saab95.getCurrentSpeed());
    }

    @org.junit.Test
    public void testSaab95DecrementSpeed() {
        saab95.setCurrentSpeed(5);
        double startSpeed = saab95.getCurrentSpeed();
        saab95.decrementSpeed(1);
        assertTrue(startSpeed > saab95.getCurrentSpeed());
    }

    @org.junit.Test
    public void testSaab95Gas() {
        double startSpeed = saab95.getCurrentSpeed();
        saab95.gas(1);
        assertTrue(startSpeed < saab95.getCurrentSpeed());
    }

    @org.junit.Test
    public void testSaab95Break() {
        saab95.setCurrentSpeed(5);
        double startSpeed = saab95.getCurrentSpeed();
        saab95.brake(1);
        assertTrue(startSpeed > saab95.getCurrentSpeed());
    }

    @org.junit.Test
    public void testVolvo240SpeedFactor() {
        assertTrue(volvo240.speedFactor() ==
                (0.01 * 1.25 * 100));
    }

    @org.junit.Test
    public void testVolvo240IncrementSpeed() {
        double startSpeed = volvo240.getCurrentSpeed();
        volvo240.incrementSpeed(1);
        assertTrue(startSpeed < volvo240.getCurrentSpeed());
    }

    @org.junit.Test
    public void testVolvo240DecrementSpeed() {
        volvo240.setCurrentSpeed(5);
        double startSpeed = volvo240.getCurrentSpeed();
        volvo240.decrementSpeed(1);
        assertTrue(startSpeed > volvo240.getCurrentSpeed());
    }

    @org.junit.Test
    public void testCarMoveUp() {
        saab95.setCurrentSpeed(2);
        double yPosistion = saab95.getY();
        saab95.setDirection(Direction.UP);
        saab95.move();
        assertTrue(yPosistion < saab95.getY());
    }

    @org.junit.Test
    public void testCarMoveRight() {
        saab95.setCurrentSpeed(2);
        double xPosistion = saab95.getX();
        saab95.setDirection(Direction.RIGHT);
        saab95.move();
        assertTrue(xPosistion < saab95.getX());
    }

    @org.junit.Test
    public void testCarMoveDown() {
        saab95.setCurrentSpeed(2);
        double yPosistion = saab95.getY();
        saab95.setDirection(Direction.DOWN);
        saab95.move();
        assertTrue(yPosistion > saab95.getY());
    }


    @org.junit.Test
    public void testCarMoveLeft() {
        saab95.setCurrentSpeed(2);
        double xPosition = saab95.getX();
        saab95.setDirection(Direction.LEFT);
        saab95.move();
        assertTrue(xPosition > saab95.getX());
    }


    @org.junit.Test
    public void testCarUpTurnRight() {
        volvo240.setDirection(Direction.UP);
        volvo240.turnRight();
        assertSame(volvo240.getDirection(), Direction.RIGHT);
    }


    @org.junit.Test
    public void testCarRightTurnRight() {
        volvo240.setDirection(Direction.RIGHT);
        volvo240.turnRight();
        assertSame(volvo240.getDirection(), Direction.DOWN);
    }


    @org.junit.Test
    public void testCarUpTurnLeft() {
        volvo240.setDirection(Direction.UP);
        volvo240.turnLeft();
        assertSame(volvo240.getDirection(), Direction.LEFT);
    }

    @org.junit.Test
    public void testCarDownTurnLeft() {
        volvo240.setDirection(Direction.DOWN);
        volvo240.turnLeft();
        assertSame(volvo240.getDirection(), Direction.RIGHT);
    }


    @org.junit.Test
    public void testCarGetColor() {
        assertSame(saab95.getColor(), Color.red);
    }


    @org.junit.Test
    public void testCarGetModelName() {
        assertSame(volvo240.getModelName(), "Volvo240");
    }


    @org.junit.Test
    public void testCarStartEngine() {
        saab95.setCurrentSpeed(0);
        saab95.startEngine();
        assertTrue(saab95.getCurrentSpeed() > 0);
    }

    @org.junit.Test
    public void testCarGetNrDoors() {
        assertSame(volvo240.getNrDoors(), 4);
    }
}
