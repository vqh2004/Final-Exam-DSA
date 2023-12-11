package BICYCLE_MANAGEMENT;

public class Station {
    private BicyclePriorityManager station;
    private String name;

    public Station(String name) {
        this.station = new BicyclePriorityManager();
        this.name = name;
    }

    public Station(BicyclePriorityManager station, String name) {
        this.station = station;
        this.name = name;
    }

    public void insertBicycle(Bicycle bicycle) {
        station.insert(bicycle);
    }

    public Bicycle rentBicycle() {
        return station.export();
    }

    public boolean isStationEmpty() {
        return station.isEmpty();
    }

    public String getName() {
        return name;
    }
}
