package BICYCLE_MANAGEMENT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
//    void findTheShortestPath(Vertex vertex) {
//        vertex.setDistance(0);
//        vertex.setVisited(true);
//
//        PriorityQueue<Vertex> vertices = new PriorityQueue<>();
//        vertices.add(vertex);
//
//        while (!vertices.isEmpty()) {
//            Vertex top = vertices.poll();
//            for (Edge e : top.getAdjEdge()) {
//                Vertex endV = e.getEndPoint();
//
//                if (!endV.isVisited()) {
//                    double newDist = top.getDistance() + e.getDist();
//                    if (newDist < endV.getDistance()) {
//                        vertices.remove(endV);
//                        endV.setDistance(newDist);
//                        endV.setPrevious(top);
//                        vertices.add(endV);
//                    }
//                }
//            }
//            top.setVisited(true);
//        }
//    }

    //tìm trạm gần nhất với vị trí của khách hàng (vertex)
    Vertex findTheNearestStation(Vertex vertex) {
        vertex.setDistance(0);

        HeapPriorityQueue vertices = new HeapPriorityQueue();
        vertices.insert(vertex);

        while (!vertices.isEmpty()) {
            Vertex top = vertices.removeMin();
            for (Edge e : top.getAdjEdge()) { // xét các cạnh kề với đỉnh top
                Vertex endV = e.getEndPoint();
                if (!endV.isVisited()) {
                    //distance là khoảng cách từ đỉnh vertex đến đỉnh endV
                    // dist là trọng số của cạnh có đỉnh đầu là top và đỉnh cuối là endV
                    double newDist = top.getDistance() + e.getDist();
                    if (newDist < endV.getDistance()) {
                        endV.setDistance(newDist);
                        endV.setPrevious(top);
                        vertices.insert(endV);
                    }
                }
//                printPriority(vertices);
            }
            if(vertices.min().isRealStation()){
                return vertices.min();
            }
            top.setVisited(true);
        }
        return null;
    }

    public void printPriority(HeapPriorityQueue vertices){
        vertices.print();
    }

    public List<Vertex> getTheShortestPath(Vertex vertex) {
        List<Vertex> vertexList = new ArrayList<>();
        Vertex tmp = vertex;
        while (tmp.getPrevious() != null) {
            vertexList.add(tmp.getPrevious());
            tmp = tmp.getPrevious();
        }
        Collections.reverse(vertexList);
        return vertexList;
    }

    void printList(Vertex vertex) {
        List<Vertex> vertices = this.getTheShortestPath(vertex);
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getName() + " -> ");
        }
        System.out.print(vertex.getName());
    }

}
