package BICYCLE_MANAGEMENT;

import java.util.LinkedList;
import java.util.List;


public class Vertex {
    private boolean visited;
    private Object station;
    private List<Edge> adjEdge; // danh sách cạnh kề với đỉnh

    private double distance = Integer.MAX_VALUE; // khởi tạo khoảng cách đầu tiên là max value
    private Vertex previous;

    protected Vertex next;

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
        if (this.station instanceof Station) {
            return ((Station) station).getName();
        }
        return station;
    }

    public boolean isRealStation() {
        return this.station instanceof Station;
    }

    public void setStation(Object name) {
        this.station = name;
    }

    public List<Edge> getAdjEdge() {
        return adjEdge;
    }

    public void addNeighbour(Edge edge) {
        this.adjEdge.add(edge); //đỉnh đầu
        edge.getEndPoint().adjEdge.add(new Edge(edge.getDist(), edge.getStartPoint(), this)); // đỉnh cuối
    }

    public void removeNeighbour(Vertex v) {
        for (Edge e : this.adjEdge) {
            if (e.getEndPoint() == v) {
                adjEdge.remove(e);
                break;
            }
        }
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

    public void setNext(Vertex next) {
        this.next = next;
    }
    double dist(Vertex v1, Vertex v2){
        Edge e = new Edge(v1,v2);
        if(e.isEdge()){
            for (Edge e1 : v1.adjEdge){
                if(e1.getEndPoint() == v2){
                    double d = e1.getDist();
                    return d;
                }
            }
        }
        return -1;
    }

    // nhập địa chỉ của khách hàng
    public void addCustomerPosition(double distPoint1, Vertex point1, double distPoint2, Vertex point2) {
        Edge tmp = new Edge(point1, point2);
        if (!tmp.isEdge()) {
            System.out.println("Không tồn tại đường đi giữa 2 vị trí "+point1.getName()+" và "+point2.getName()+", kiểm tra lại khi thêm vị trí của khách hàng!!!");
        } else if(distPoint1+distPoint2 != dist(point1,point2)){
            System.out.println("Khoảng cách giữa vị trí của khách hàng với 2 điểm sai, kiểm tra lại khi thêm vị trí của khách hàng!!!");
        } else {
            point1.removeNeighbour(point2);
            point2.removeNeighbour(point1);
            point1.addNeighbour(new Edge(distPoint1, point1, this));
            point2.addNeighbour(new Edge(distPoint2, point2, this));
        }

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

}
