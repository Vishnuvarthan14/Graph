import java.util.*;
import java.util.HashMap;

public class Graph_map {
        HashMap <Integer, Set<Integer>> adjs = new HashMap<>();

    public void addEdges(int u,int v)
    {
        if(!adjs.containsKey(u))
            adjs.put(u,new HashSet<>());
        adjs.get(u).add(v);

        if(!adjs.containsKey(v))
            adjs.put(v,new HashSet<Integer>());
        adjs.get(v).add(u);
    }

    public HashMap<Integer,Set<Integer>> getMap()
    {
        return adjs;
    }

    public void count_edges_vertices ()
    {
        int count_vertices = adjs.size();
        int count_edges = 0;

        for(Set<Integer> edges: adjs.values())
            count_edges+=edges.size();

        System.out.println("number of vertices:"+count_vertices);
        System.out.println("number of edjes:"+count_edges/2);
    }
}
