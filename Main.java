public class Main {
    public static void main(String[] args) {
//        Graph graph = new Graph(5);
//        graph.addEdges(0,1);
//        graph.addEdges(0,3);
//        graph.addEdges(1,2);
//        graph.addEdges(1,3);
//        graph.addEdges(2,4);
//        graph.addEdges(3,4);
//
//        graph.display();
//        graph.bfs(0);
//        graph.DFS(0);

        disjoint ds = new disjoint(8);
        ds.union(1,2);
        ds.union(2,3);
        ds.union(4,3);
        ds.union(6,7);
        ds.union(5,6);
        //ds.union(3,7);

        if(ds.find(3)==ds.find(7))
            System.out.println(true);
        else
            System.out.println(false);
    }
}
