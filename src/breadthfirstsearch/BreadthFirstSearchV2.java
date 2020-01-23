package breadthfirstsearch;

import java.util.*;

public class BreadthFirstSearchV2 {

    private List<Integer> spanningTree;
    private List<Boolean> visited;
    private Queue<Integer> queue;
    private Map<Integer, List<Integer>> adjancencyMap;

    public BreadthFirstSearchV2(Map<Integer, List<Integer>> adjancencyMap){

        this.adjancencyMap = adjancencyMap;
        this.queue = new LinkedList<>();
        this.spanningTree = new ArrayList<>();
        this.visited = new ArrayList<>();

        // no node zero
        for(int i=0; i<=adjancencyMap.size()+1; i++){
            visited.add(false);
        }
    }

    public void generateBFS(Integer start){

        visit(start);
        while(!queue.isEmpty()){
            Integer node = queue.remove();
            List<Integer> neighbors = adjancencyMap.get(node);
            neighbors.stream().filter(n -> !visited.get(n)).forEach(n -> visit(n));
        }
        spanningTree.stream().forEach(n -> System.out.print(n+"\t"));
    }

    private void visit(Integer i){

        queue.add(i);
        visited.set(i, true);
        spanningTree.add(i);
    }
}
