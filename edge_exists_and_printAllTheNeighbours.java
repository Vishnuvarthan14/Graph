import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

public class edge_exists_and_printAllTheNeighbours {

    public static void main(String[] args) {
        Graph_map g4 = new Graph_map();
        int source=0;
        int find=4;

        g4.addEdges(0,2);
        g4.addEdges(0,3);
        g4.addEdges(2,4);

        HashMap <Integer, Set<Integer>> adjs = g4.getMap();

            for(int key:adjs.keySet())
            {
                System.out.println(key+" : "+adjs.get(key));
            }
        System.out.println(neighbour_exists(source,find,adjs));
    }

    public static boolean neighbour_exists(int source,int find,HashMap<Integer,Set<Integer>> adjs)
    {
        return adjs.get(source).contains(find);
    }
}
