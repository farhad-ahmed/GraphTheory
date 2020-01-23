package depthfirstsearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearchTest {

    public static void main(String[] args) {

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(generateAdjancencyMap());
        depthFirstSearch.generateDepthFirstSearch(4);
    }

    private static Map<Integer,List<Integer>> generateAdjancencyMap(){

        Map<Integer, List<Integer>> adjancencyMap = new HashMap<>();

        List<Integer> n1 = Arrays.asList(2,3,4);
        adjancencyMap.put(1,n1);

        List<Integer> n2 = Arrays.asList(1,3);
        adjancencyMap.put(2,n2);

        List<Integer> n3 = Arrays.asList(1,2,4,5);
        adjancencyMap.put(3,n3);

        List<Integer> n4 = Arrays.asList(1,3,5);
        adjancencyMap.put(4,n4);

        List<Integer> n5 = Arrays.asList(3,4,6,7);
        adjancencyMap.put(5,n5);

        List<Integer> n6 = Arrays.asList(5);
        adjancencyMap.put(6,n6);

        List<Integer> n7 = Arrays.asList(5);
        adjancencyMap.put(7,n7);

        return adjancencyMap;
    }
}
