import java.util.*;
import java.util.HashMap;

public class remove_edges_vertex {
    public static void main(String[] args) {

        Graph_map g5 = new Graph_map();

        g5.addEdges(0,1);
        g5.addEdges(1,2);
        g5.addEdges(2,4);
        g5.addEdges(4,5);
        g5.addEdges(0,5);

        int r1=1;
        int r2=2;
        HashMap<Integer,Set<Integer>> adjs = g5.getMap();
        display(adjs);

        remove_edges(adjs,r1,r2);
        System.out.println();
        display(adjs);

        int remove=4;
        remove_vertex(adjs,remove);
        System.out.println();
        display(adjs);

    }
    public static void remove_edges(HashMap<Integer,Set<Integer>> adjs,int r1,int r2)
    {
        if(adjs.containsKey(r1))
        adjs.get(r1).remove(r2);

        if(adjs.containsKey(r2))
        adjs.get(r2).remove(r1);
    }

    public static void remove_vertex(HashMap<Integer,Set<Integer>> adjs,int remove)
    {
        for(int i:adjs.get(remove))
        {
            adjs.get(i).remove(remove);
        }
        adjs.remove(remove);
    }
public static void display(HashMap<Integer,Set<Integer>> adjs)
{
    for(int key:adjs.keySet())
    {
        System.out.println(key+" : "+adjs.get(key));
    }
}
}
