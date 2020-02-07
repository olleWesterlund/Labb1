public class TruckBed implements MovableTruckBed {
    private int currentDegree;
    private boolean isReadyToDrive;
    private final int maxDegree;
    private final int minDegree;

    /**
     * Constructor for TruckBed Object.
     *
     * @param currentDegree  Holds current degree of the TruckBed.
     * @param isReadyToDrive Checks if the TruckBed is in drivable mode.
     * @param minDegree      Sets minimum degree of the TruckBed.
     * @param maxDegree      Sets maximum degree of the TruckBed.
     */
    public TruckBed(int currentDegree, boolean isReadyToDrive, int minDegree, int maxDegree) {
        this.currentDegree = currentDegree;
        this.isReadyToDrive = isReadyToDrive;
        this.minDegree = minDegree;
        this.maxDegree = maxDegree;
    }

    /**
     * @return current degree of the TruckBed.
     */
    public int getCurrentDegree() {
        return currentDegree;
    }

    /**
     * @return true or false depending on current degree.
     */
    public boolean isReadyToDrive() {
        return isReadyToDrive;
    }

    /**
     * Sets TruckBed up or down depending on the previous mode.
     *
     * @param truck the Truck of the TruckBed we're using the method on.
     */
    public void setTruckBed(Truck truck) {
        if (truck.getCurrentSpeed() == 0) {
            if (currentDegree == minDegree) {
                while (currentDegree < maxDegree) {
                    truckBedUp();
                }
                isReadyToDrive = false;
            } else {
                while (currentDegree > minDegree) {
                    truckBedDown();
                }
                isReadyToDrive = true;
            }
        } else {
            throw new IllegalArgumentException("Can't set truck bed while driving");
        }
    }

    /**
     * Sets TruckBed to the value of parameter degree if it's in the range of minDegree and maxDegree.
     *
     * @param degree the degree that we want to set the current degree of the TruckBed to.
     * @param truck  the Truck of the TruckBed we're using the method on.
     */
    public void setTruckBed(int degree, Truck truck) {
        if (truck.getCurrentSpeed() == 0) {
            if (degree < minDegree || degree > maxDegree) {
                throw new IllegalArgumentException("degree must be in range [" + minDegree + "," + maxDegree + "]");
            } else {
                if (currentDegree < degree) {
                    while (currentDegree < degree) {
                        truckBedUp();
                    }
                    isReadyToDrive = false;
                } else if (currentDegree > degree) {
                    while (currentDegree > degree) {
                        truckBedDown();
                    }
                    if (currentDegree == 0) {
                        isReadyToDrive = true;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Can't set truck bed while driving");
        }
    }

    /**
     * Increases current degree by 1.
     */
    @Override
    public void truckBedUp() {
        currentDegree++;
    }

    /**
     * Increases current degree by 1.
     */
    @Override
    public void truckBedDown() {
        currentDegree--;
    }
}
