package BICYCLE_MANAGEMENT;

public class Edge {
    private double dist; // trọng số của cạnh
    private Vertex startPoint;
    private Vertex endPoint;
    public Edge(double weight, Vertex vertex1, Vertex vertex2) {
        this.dist = weight;
        this.startPoint = vertex1;
        this.endPoint = vertex2;
    }

    public Edge(Vertex startPoint, Vertex endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }


    public double getDist() {
        return dist;
    }

    public boolean isEdge(){
        for(Edge e : startPoint.getAdjEdge()){ // với mỗi cạnh có điểm đầu là startPoint
            if(e.getEndPoint() == endPoint){ //kiểm tra điểm cuối của cạnh có phải là endPoint không
                return true;
            }
        }
        return false;
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
        return "Edge{endV=" + endPoint.getName() + "dist="+this.dist+ '}';
    }
}
