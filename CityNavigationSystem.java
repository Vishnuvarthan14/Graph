/*Problem Solving for the day - BFS

City navigation system.

The city has several junctions (nodes), and roads (edges) connect them. Some junctions may not be connected at all.

A user wants to check if it is possible to travel from Junction A to Junction B using the available roads.

Use BFS to check whether there is a path from source to destination.

Your Task:

Represent the city map as a graph using an adjacency list.

Implement BFS to determine if destination is reachable from the source.

Print “Path Exists” or “No Path Exists”.

Test case 01 :

Number of Junctions: 5
Roads:
0 <-> 1
0 <-> 2
1 <-> 3

Start Junction: 0
Destination Junction: 3

Output :

Path Exists

Test case 2 :

Number of Junctions: 4
Roads:
1 <-> 2

Start Junction: 0
Destination Junction: 3

Output :

No Path Exists*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CityNavigationSystem {
    public static void main(String[] args) {
        int n=4; //no of vertices
        Graph g1 = new Graph(n);

        int source=0;
        int dest=3;
        ArrayList<ArrayList<Integer>> list =g1.getAdjs();
        g1.addEdges(1,2);

        System.out.println(navigate(source,dest,list));
    }
    public static boolean navigate(int source,int dest,ArrayList<ArrayList<Integer>> list)
    {
        Queue <Integer> que =new  LinkedList<>();
        boolean visited[] = new boolean[list.size()];
        que.add(source);
        visited[source]=true;

        while(!que.isEmpty())
        {
            int vertex = que.remove();
            if(vertex==dest)
                return true;
            for(int i=0;i<list.get(vertex).size();i++)
            {
                int av = list.get(vertex).get(i);
                if(!visited[av])
                {
                    que.add(av);
                    visited[av]=true;
                }
            }
        }
        return false;
    }
}
