package BICYCLE_MANAGEMENT;

import java.util.concurrent.atomic.AtomicInteger;

public class Bicycle {
    private int id;
    private final long durableTime = 1000000;  //hour
    private double timeTraveled; //hour
    private static final String ID_FORMAT = "BIKE%04d";

    private static AtomicInteger idCounter = new AtomicInteger(2300);



    public Bicycle() {
        this.id = generateUniqueId();
        this.timeTraveled = 0;
    }

    // Function to create a unique id for each bicycle
    private int generateUniqueId() {
        return idCounter.getAndIncrement();
    }

    public String getId() {
        return String.format(ID_FORMAT, id);
    }

    public long getDurableTime() {
        return durableTime;
    }

    public double getTimeTraveled() {
        return timeTraveled;
    }


    public double updateTraveledTime(double time) {
        return timeTraveled += time ;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + getId() +
                ", timeTraveled=" + timeTraveled +
                '}';
    }
}
