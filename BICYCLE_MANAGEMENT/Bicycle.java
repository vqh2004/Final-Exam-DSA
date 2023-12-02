package BICYCLE_MANAGEMENT;

import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalTime;

public class Bicycle {
    private int id;
    private final long durableTime = 1000000;
    private long timeTraveled;
    private static final String ID_FORMAT = "BIKE%04d";

    private static AtomicInteger idCounter = new AtomicInteger(22000000);



    public Bicycle() {
        this.id = generateUniqueId();
    }

    // Function to create an unique Id for each bicycle
    private int generateUniqueId() {
        return idCounter.getAndIncrement();
    }

    public String getId() {
        return String.format(ID_FORMAT, id);
    }

    public long getDurableTime() {
        return durableTime;
    }

    public long getTimeTraveled() {
        return timeTraveled;
    }

    public long updateTraveledTime(long time) {
        return timeTraveled += time ;
    }
}
