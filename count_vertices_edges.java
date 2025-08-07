import java.util.*;
public class count_vertices_edges {
    public static void main(String[] args) {
        Graph_map g3 = new Graph_map();
        g3.addEdges(1,2);
        g3.addEdges(1,3);
        g3.addEdges(2,4);

        g3.count_edges_vertices();
    }

}
