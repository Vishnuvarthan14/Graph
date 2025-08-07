import java.util.ArrayList;
import java.util.Stack;

/* Problem solving for the day - DFS

Detecting a Path Through Secret Tunnels (DFS)

In a dungeon game, players must navigate through underground tunnels to reach a hidden treasure room. Each tunnel connects two chambers (nodes), and not all chambers are directly connected. The dungeon map is represented as an undirected graph.

Your task is to use DFS (Depth-First Search) to determine whether a path exists from the Entrance Chamber to the Treasure Room.

Input :

Number of Chambers: 6
Tunnels:
0 <-> 1
0 <-> 2
1 <-> 3
3 <-> 4
4 <-> 5

Entrance: 0
Treasure: 5

Output :

Treasure Reachable

Test case 2 :

Number of Chambers: 5

Tunnels:
0 <-> 1
1 <-> 2
3 <-> 4

Entrance: 0
Treasure: 4

Output :

No Path to Treasure*/
public class NavigateTreasure {
    public static void main(String[] args) {
        int n=5; //no of vertices
        Graph g2 = new Graph(n);
        int source=0;
        int dest=4;
//        g2.addEdges(0,1);  n=6 source=0 dest=5
//        g2.addEdges(0,2);
//        g2.addEdges(1,3);
//        g2.addEdges(3,4);
//        g2.addEdges(4,5);

        g2.addEdges(0,1);
        g2.addEdges(1,2);
        g2.addEdges(3,4);
        ArrayList<ArrayList<Integer>> list =g2.getAdjs();
        System.out.println(navigate(source,dest,list));
    }
    public static boolean navigate(int source,int dest,ArrayList<ArrayList<Integer>> list)
    {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[list.size()];

        stack.push(source);
        visited[source]=true;

        while(!stack.isEmpty())
        {
            int vertex= stack.pop();
            if(vertex==dest)
                return true;

            for(int i=0;i<list.get(vertex).size();i++)
            {
                int av = list.get(vertex).get(i);
                if(!visited[av])
                {
                    visited[av]=true;
                    stack.push(av);
                }
            }
        }
        return false;
    }
}
