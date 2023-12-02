package BICYCLE_MANAGEMENT;

public class BicyclePriorityManager {
    Bicycle[] station;
    int n = 0;
    protected int defaultSize = 10000;

    public BicyclePriorityManager() {
        this.station = new Bicycle[defaultSize];
    }
    public boolean isEmpty() {
        return n == 0;
    }

    // function to insert a bicycle from customer
    public void insert(Bicycle bicycle) {
        checkToInsert();
        checkExpired(bicycle);
        int insertionIndex = binarySearch((int) bicycle.getTimeTraveled());
        shiftAndInsert(insertionIndex, bicycle);
    }

    // function to export bicycle when customer rent
    public Bicycle export() {
        if (n >= 0) {
            Bicycle bicycleExport = station[0];
            shiftToLeft();
            n--;
            return bicycleExport;
        } else {
            throw new RuntimeException("No bicycle available for export.");
        }
    }

    // function to check the expired bicycle
    public void checkExpired(Bicycle bicycle) throws RuntimeException{
        if (bicycle.getTimeTraveled() > bicycle.getDurableTime()) {
            System.out.println("Expired bicycle: " + bicycle.getId());
        }
    }
    public void checkToInsert() throws ArrayIndexOutOfBoundsException {
        if (n == defaultSize) {
            throw new ArrayIndexOutOfBoundsException("Priority queue is full");
        }
    }

    public void checkToRemove() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Priority queue is empty");
        }
    }
    private int binarySearch(int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midKey = (int) station[mid].getTimeTraveled();

            if (midKey == key) {
                return mid;
            } else if (midKey < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // Shift elements to make space for the new entry and insert it
    private void shiftAndInsert(int index, Bicycle bicycle) {
        for (int i = n - 1; i >= index; i--) {
            station[i + 1] = station[i];
        }
        station[index] = bicycle;
        n++;
    }
    private void shiftToLeft() {
        for (int i = 1; i < n; i++) {
            station[i - 1] = station[i];
        }
    }
}
