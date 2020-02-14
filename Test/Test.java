import org.junit.Assert;
import org.junit.Before;

import java.awt.*;

import static org.junit.Assert.*;

public class Test {
    private Saab95 saab95;
    private Volvo240 volvo240;
    private CarTransport carTransport;
    private Scania scania;
    private TruckBed transportTruckBed;
    private TruckBed scaniaTruckBed;
    private Workshop<Volvo240> volvoService;
    private Workshop<Saab95> saabService;
    private Workshop<Car> carService;


    @Before
    public void init() {
        saab95 = new Saab95();
        volvo240 = new Volvo240();
        carTransport = new CarTransport();
        scania = new Scania();
        transportTruckBed = carTransport.getTruckBed();
        scaniaTruckBed = scania.getTruckBed();
        volvo240.setY(carTransport.getY() - 2);
        volvo240.setX(carTransport.getX() - 2);
        volvoService = new Workshop<>(10);
        saabService = new Workshop<>(10);
        carService = new Workshop<>(10);
    }

    @org.junit.Test
    public void testSaab95TurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.isTurboOn());
    }

    @org.junit.Test
    public void testSaab95TurboOff() {
        saab95.setTurboOff();
        assertFalse(saab95.isTurboOn());
    }

    @org.junit.Test
    public void testSaab95SpeedFactorWithTurbo() {
        saab95.setTurboOn();
        assertEquals(saab95.speedFactor(), saab95.getEnginePower() * 0.01 * 1.3, 0.0);
    }


    @org.junit.Test
    public void testSaab96SpeedFactorNoTurbo() {
        saab95.setTurboOff();
        assertEquals(saab95.speedFactor(), saab95.getEnginePower() * 0.01, 0.0);
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
        assertEquals(volvo240.speedFactor(), (0.01 * 1.25 * 100), 0.0);
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
        double yPosition = saab95.getY();
        saab95.setDirection(Direction.UP);
        saab95.move();
        assertTrue(yPosition < saab95.getY());
    }

    @org.junit.Test
    public void testCarMoveRight() {
        saab95.setCurrentSpeed(2);
        double xPosition = saab95.getX();
        saab95.setDirection(Direction.RIGHT);
        saab95.move();
        assertTrue(xPosition < saab95.getX());
    }

    @org.junit.Test
    public void testCarMoveDown() {
        saab95.setCurrentSpeed(2);
        double yPosition = saab95.getY();
        saab95.setDirection(Direction.DOWN);
        saab95.move();
        assertTrue(yPosition > saab95.getY());
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

    @org.junit.Test
    public void testMoveCarTransport() {
        double transportY = carTransport.getY();
        carTransport.setCurrentSpeed(70);
        double currentSpeed = carTransport.getCurrentSpeed();
        carTransport.move();
        assertEquals(carTransport.getY(), transportY + currentSpeed, 0.0);
    }

    @org.junit.Test
    public void testTurnCarTransportLeft() {
        carTransport.setDirection(Direction.RIGHT);
        carTransport.turnLeft();
        assertSame(carTransport.getDirection(), Direction.UP);
    }

    @org.junit.Test
    public void testTurnCarTransportRight() {
        carTransport.setDirection(Direction.DOWN);
        carTransport.turnRight();
        assertSame(carTransport.getDirection(), Direction.LEFT);
    }


    @org.junit.Test
    public void testUpdateLoadedCarPositions() {
        carTransport.setTruckBed();
        carTransport.loadCars(volvo240);
        carTransport.setTruckBed();
        carTransport.setCurrentSpeed(70);
        carTransport.move();
        assertEquals(carTransport.getY(), volvo240.getY(), 0.0);
    }

    @org.junit.Test
    public void testSetTruckBedForCarTransport() {
        carTransport.setTruckBed();
        assertFalse(transportTruckBed.isReadyToDrive());
    }

    @org.junit.Test
    public void testLoadVolvo240OnCarTransportSize() {
        carTransport.setTruckBed();
        carTransport.loadCars(volvo240);
        assertSame(carTransport.getCarsOnTransport().size(), 1);
    }

    @org.junit.Test
    public void testLoadVolvo240OnCarTransportContainsVolvo240() {
        carTransport.setTruckBed();
        carTransport.loadCars(volvo240);
        assertEquals(carTransport.getCarsOnTransport().getFirst(), volvo240);
    }

    @org.junit.Test
    public void testUnloadVolvo240FromCarTransportSize() {
        carTransport.setTruckBed();
        carTransport.loadCars(volvo240);
        carTransport.unloadCars();
        assertEquals(0, carTransport.getCarsOnTransport().size());
    }

    @org.junit.Test
    public void testUnloadVolvo240FromCarTransportPositionCorrect() {
        carTransport.setTruckBed();
        carTransport.loadCars(volvo240);
        carTransport.unloadCars();
        assertEquals(volvo240.getX(), carTransport.getX() + 1, 0.0);
    }

    @org.junit.Test
    public void testScaniaSetTruckBed() {
        scania.setTruckBed(60);
        assertEquals(60, scaniaTruckBed.getCurrentDegree());
    }

    @org.junit.Test
    public void testAddVolvo240ToVolvo240WorkshopSize() {
        volvoService.putCarInWorkshop(volvo240);
        assertEquals(1, volvoService.carsInWorkshop.size());
    }

    /*
    @org.junit.Test
    public void testAddSaab95toVolvo240Workshop() {
        volvoService.putCarInWorkshop(saab95);
    }
     */

    @org.junit.Test
    public void testAddVolvo240AndSaab95ToCarWorkshopSize() {
        carService.putCarInWorkshop(volvo240);
        carService.putCarInWorkshop(saab95);
        assertEquals(2, carService.carsInWorkshop.size());
    }

    @org.junit.Test
    public void testGetVolvo240FromWorkshopSize() {
        volvoService.putCarInWorkshop(volvo240);
        volvoService.getCarFromWorkshop(volvo240);
        assertEquals(0, volvoService.carsInWorkshop.size());
    }

    @org.junit.Test
    public void testGetMaxNrOfCarsAWorkshopCanHandle() {
        assertEquals(10, volvoService.getMaxNrOfCars());
    }
}
