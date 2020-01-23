package depthfirstsearch;

import java.util.*;

public class DepthFirstSearch {

    private List<Integer> visitedNode;
    private List<Boolean> visited;
    private Stack<Integer> stack;
    private Map<Integer,List<Integer>> adjacencyMap;

    public DepthFirstSearch(Map<Integer, List<Integer>> adjacencyMap){

        this.adjacencyMap = adjacencyMap;
        this.stack = new Stack<>();
        this.visitedNode = new ArrayList<>();
        this.visited = new ArrayList<>();

        for(int i=0; i<=adjacencyMap.size()+1; i++){
            visited.add(false);
        }
    }

    public void generateDepthFirstSearch(Integer source){

        visit(source);
        while(!stack.empty()){
            Integer pop = stack.pop();
            Optional<Integer> next = findUnvisitedNode(pop);
            if(next.isPresent()){
                // the current node is not explored yet, put it back
                stack.push(pop);
                // go and track the new one
                visit(next.get());
            }
        }
        visitedNode.stream().forEach(n -> System.out.print(n+"\t"));
    }

    private void visit(Integer source){

        if(!visited.get(source)){
            visitedNode.add(source);
            visited.set(source, true);
            stack.push(source);
        }
    }

    private Optional<Integer> findUnvisitedNode(Integer source){

        List<Integer> neighbors = adjacencyMap.get(source);
        return neighbors.stream().filter(n -> !visited.get(n)).findFirst();
    }
}
