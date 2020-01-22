package breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    private List<Boolean> visited;

    private Queue<Integer> queue;

    private int [][] matrix;

    private List<Integer> spanningTree;

    public BreadthFirstSearch(int [][] matrix){

        this.matrix = matrix;
        this.queue = new LinkedList<>();
        this.spanningTree = new ArrayList<>();
        this.visited = new ArrayList<>();

        for(int i=0; i<matrix.length; i++){
            visited.add(false);
        }
    }

    public void generateBFS(int start){

        visit(start);
        while(!queue.isEmpty()){
           Integer q = queue.remove();
           for(int v =1; v<matrix[q].length; v++){
               if(matrix[q][v] == 1 && !visited.get(v)){
                   visit(v);
               }
           }
        }
        printSpanningTree();
    }

    private void visit(Integer i){

        visited.set(i, true);
        spanningTree.add(i);
        queue.add(i);
    }

    private void printSpanningTree(){
        spanningTree.stream().forEach(n -> System.out.print(n+"\t"));
    }
}

