package dijkstra;

public class Edge {

    private int cost;

    private int  outGoingVertexId;

    public Edge(int cost, int outGoingVertexId){

        this.cost = cost;
        this.outGoingVertexId = outGoingVertexId;
    }

    public int getCost() {
        return cost;
    }

    public int getOutGoingVertexId() {
        return outGoingVertexId;
    }
}
