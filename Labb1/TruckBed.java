public class TruckBed implements MovableTruckBed {
    private int currentDegree; // Current degree of the truck bed
    private boolean isReadyToDrive;
    private final int maxDegree;
    private final int minDegree;

    public TruckBed(int currentDegree, boolean isReadyToDrive, int minDegree, int maxDegree) {
        this.currentDegree = currentDegree;
        this.isReadyToDrive = isReadyToDrive;
        this.minDegree = minDegree;
        this.maxDegree = maxDegree;
    }

    public int getCurrentDegree() {
        return currentDegree;
    }

    public boolean isReadyToDrive() {
        return isReadyToDrive;
    }

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

    @Override
    public void truckBedUp() {
        currentDegree++;
    }

    @Override
    public void truckBedDown() {
        currentDegree--;
    }
}
