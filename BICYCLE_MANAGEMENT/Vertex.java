package BICYCLE_MANAGEMENT;

import java.util.LinkedList;
import java.util.List;


public class Vertex implements Comparable<Vertex> {
    private boolean visited;
    private Object station;
    private List<Edge> adjEdge;

    private double distance = Integer.MAX_VALUE;
    private Vertex previous;

    Vertex(Object name) {
        this.station = name;
        this.visited = false;
        this.adjEdge = new LinkedList<>();
    }


    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Object getName() {
        if(this.station instanceof Station){
            return ((Station) station).getName();
        }
        return station;
    }

    public void setStation(Object name) {
        this.station = name;
    }

    public List<Edge> getAdjEdge() {
        return adjEdge;
    }

    public void addNeighbour(Edge edge) {
        this.adjEdge.add(edge);
        edge.getEndPoint().adjEdge.add(new Edge(edge.getDist(), edge.getStartPoint(), this));
    }

    public void setAdjVer(List<Edge> adjVer) {
        this.adjEdge = adjVer;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "visited=" + visited +
                ", name='" + station + '\'' +
                ", adjEdge=" + adjEdge +
                ", distance=" + distance +
                ", previous=" + previous +
                '}';
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.distance);
    }

}
