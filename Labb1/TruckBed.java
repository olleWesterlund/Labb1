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
    protected int getCurrentDegree() {
        return currentDegree;
    }

    /**
     * @return true or false depending on current degree.
     */
    protected boolean isReadyToDrive() {
        return isReadyToDrive;
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

    protected void setCurrentDegree(int currentDegree) {
        this.currentDegree = currentDegree;
    }

    protected void setReadyToDrive(boolean readyToDrive) {
        isReadyToDrive = readyToDrive;
    }

    protected int getMaxDegree() {
        return maxDegree;
    }

    protected int getMinDegree() {
        return minDegree;
    }
}
