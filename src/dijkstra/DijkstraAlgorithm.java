package dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DijkstraAlgorithm {

    private Map<Integer, Vertex> map;

    private List<Boolean> visited;

    private List<Integer> shortestPaths;

    private int totalVisitedNodes;


    public DijkstraAlgorithm(Map<Integer, Vertex> map){

        this.map = map;
        this.totalVisitedNodes = 0;
        this.shortestPaths = new ArrayList<>();
        this.visited = new ArrayList<>();

        for(int i=0; i<=map.size(); i++){
            this.visited.add(false);
            this.shortestPaths.add(Integer.MAX_VALUE);
        }
    }

    public void getShortestPathForSourceNode(Integer sourceNode){

        init(sourceNode);
        while(totalVisitedNodes !=map.size()){

            VertexEdge closestVertex = getClosestUnVisitedVertex();
            if(closestVertex.vertexId ==-1){
                totalVisitedNodes++;
                break;
            }
            int costFromSourceToCurrentVertex = closestVertex.distance;

            List<Edge> edges = map.get(closestVertex.vertexId).getEdges();

            for(Edge edge : edges){
                Integer neighborVertexId = edge.getOutGoingVertexId();
                Integer costFromCurrentVertex = edge.getCost();
                Integer totalCostFromTheSource = costFromCurrentVertex+costFromSourceToCurrentVertex;
                if(totalCostFromTheSource < shortestPaths.get(neighborVertexId)){
                    shortestPaths.set(neighborVertexId, totalCostFromTheSource);
                }
            }
            visited.set(closestVertex.vertexId, true);
            totalVisitedNodes++;
        }

        printShortestPaths(sourceNode);
    }

    private void init(Integer vertexId){

        visited.set(vertexId, true);
        totalVisitedNodes++;
        this.shortestPaths.set(vertexId, 0);
        Vertex vertex = this.map.get(vertexId);
        vertex.getEdges().stream().forEach(e ->shortestPaths.set(e.getOutGoingVertexId(), e.getCost()));
    }

    private VertexEdge getClosestUnVisitedVertex(){

        int min = Integer.MAX_VALUE;
        int index =-1;

        for(int i=1; i<this.shortestPaths.size(); i++){

            if(!visited.get(i) && min>shortestPaths.get(i)){
                min = shortestPaths.get(i);
                index = i;
            }
        }

        return new VertexEdge(index, min);
    }

    private void printShortestPaths(int sourceNodeId){

        System.out.println("_________________________________________________");
        System.out.println("            Source Vertex : "+sourceNodeId);
        System.out.println("_________________________________________________");
        for(int i =1; i<shortestPaths.size(); i++){
            System.out.println(String.format("Destination %s        Cost %s", i, this.shortestPaths.get(i)!=Integer.MAX_VALUE?shortestPaths.get(i):"Infinity"));

        }
    }

    private class VertexEdge{

        int vertexId;
        int distance;

        VertexEdge(int vertexId, int distance){

            this.vertexId = vertexId;
            this.distance = distance;
        }
    }
}
