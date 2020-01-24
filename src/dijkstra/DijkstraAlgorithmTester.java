package dijkstra;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

public class DijkstraAlgorithmTester {

    public static void main(String[] args) {

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(generateGraph2());
        algorithm.getShortestPathForSourceNode(1);
    }

    private static Map<Integer, Vertex> generateGraph(){

        Map<Integer, Vertex> graphMap = new HashMap<>();

        Edge e1 = new Edge(2,2);
        Edge e2 = new Edge(4,3);
        Vertex v1 = new Vertex(1, Arrays.asList(e1,e2));
        graphMap.put(v1.getId(), v1);

        Edge e3 = new Edge(1, 3);
        Edge e4 = new Edge(7,4);
        Vertex v2 = new Vertex(2, Arrays.asList(e3,e4));
        graphMap.put(v2.getId(), v2);

        Edge e5 = new Edge(3, 5);
        Vertex v3 = new Vertex(3,  Arrays.asList(e5));
        graphMap.put(v3.getId(), v3);

        Edge e6 = new Edge(1, 6);
        Vertex v4 = new Vertex(4, Arrays.asList(e6));
        graphMap.put(v4.getId(), v4);

        Edge e7 = new Edge(2, 4);
        Edge e8 = new Edge(5, 6);
        Vertex v5 = new Vertex(5, Arrays.asList(e7,e8));
        graphMap.put(v5.getId(), v5);

        Vertex v6 = new Vertex(6);
        graphMap.put(v6.getId(), v6);

        return graphMap;
    }

    private static Map<Integer, Vertex> generateGraph2(){

        Map<Integer, Vertex> graphMap = new HashMap<>();

        Edge e1 = new Edge(50,2);
        Edge e2 = new Edge(45,3);
        Edge e3 = new Edge(10,4);
        Vertex v1 = new Vertex(1, Arrays.asList(e1,e2,e3));
        graphMap.put(v1.getId(), v1);

        Edge e4 = new Edge(15,4);
        Edge e5 = new Edge(10,3);
        Vertex v2 = new Vertex(2, Arrays.asList(e4,e5));
        graphMap.put(v2.getId(), v2);

        Edge e6 = new Edge(30, 5);
        Vertex v3 = new Vertex(3,  Arrays.asList(e6));
        graphMap.put(v3.getId(), v3);

        Edge e7 = new Edge(15, 5);
        Vertex v4 = new Vertex(4, Arrays.asList(e7));
        graphMap.put(v4.getId(), v4);

        Edge e8 = new Edge(20, 2);
        Edge e9 = new Edge(35, 3);
        Vertex v5 = new Vertex(5, Arrays.asList(e8,e9));
        graphMap.put(v5.getId(), v5);

        Edge e10 = new Edge(3, 5);
        Vertex v6 = new Vertex(6, Arrays.asList(e10));
        graphMap.put(v6.getId(), v6);

        return graphMap;
    }
}
