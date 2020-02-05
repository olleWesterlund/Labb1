public class TruckBed implements MovableTruckBed {
    private int currentDegree; // Current degree of the truck bed
    private boolean isTruckBedDown;
    private final int maxDegree;
    private final int minDegree;

    public TruckBed(int currentDegree, boolean isTruckBedDown, int minDegree, int maxDegree) {
        this.currentDegree = currentDegree;
        this.isTruckBedDown = isTruckBedDown;
        this.minDegree = minDegree;
        this.maxDegree = maxDegree;
    }

    public int getMaxDegree() {
        return maxDegree;
    }

    public int getMinDegree() {
        return minDegree;
    }

    public int getCurrentDegree() {
        return currentDegree;
    }

    public void setCurrentDegree(int currentDegree) {
        this.currentDegree = currentDegree;
    }

    public boolean isTruckBedDown() {
        return isTruckBedDown;
    }

    public void setTruckBed(int degree, Truck truck) {
        if (truck.getCurrentSpeed() == 0) {
            if (degree < minDegree || degree > maxDegree) {
                throw new IllegalArgumentException("degree must be in range [" + minDegree + "," + maxDegree + "]");
            } else {
                if (currentDegree < degree) {
                    while (currentDegree < degree) {
                        truckBedUp();
                    }
                    isTruckBedDown = false;
                } else if (currentDegree > degree) {
                    while (currentDegree > degree) {
                        truckBedDown();
                    }
                    if (currentDegree == 0) {
                        isTruckBedDown = true;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Can't set truck bed while driving");
        }
    }

    @Override
    public void truckBedUp() {
        currentDegree++;
    }

    @Override
    public void truckBedDown() {
        currentDegree--;
    }
}
