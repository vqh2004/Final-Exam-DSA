package BICYCLE_MANAGEMENT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    void findTheShortestPath(Vertex vertex) {
        vertex.setDistance(0);
        vertex.setVisited(true);

        PriorityQueue<Vertex> vertices = new PriorityQueue<>();
        vertices.add(vertex);

        while (!vertices.isEmpty()) {
            Vertex top = vertices.poll();
            for (Edge e : top.getAdjEdge()) {
                Vertex endV = e.getEndPoint();

                if (!endV.isVisited()) {
                    double newDist = top.getDistance() + e.getDist();
                    if (newDist < endV.getDistance()) {
                        vertices.remove(endV);
                        endV.setDistance(newDist);
                        endV.setPrevious(top);
                        vertices.add(endV);
                    }
                }
            }
            top.setVisited(true);
        }
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
