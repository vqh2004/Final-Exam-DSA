package BICYCLE_MANAGEMENT;

public class Edge {
    private double dist;
    private Vertex startPoint;
    private Vertex endPoint;
    public Edge(double weight, Vertex vertex1, Vertex vertex2) {
        this.dist = weight;
        this.startPoint = vertex1;
        this.endPoint = vertex2;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public Vertex getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Vertex startPoint) {
        this.startPoint = startPoint;
    }

    public Vertex getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Vertex endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "Edge{endV=" + endPoint.getName() + '}';
    }
}
