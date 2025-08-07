/*You are working as a network engineer responsible for ensuring that all parts of a company's internal computer network are properly connected.

The network consists of several computers (nodes) connected by network cables (edges with weights representing latency). However, due to missing or faulty cables, some computers might be disconnected from others, forming separate components.

You are tasked to:

Apply Prim’s Algorithm starting from any computer in a component.

Continue running Prim's on unvisited components to ensure all parts are checked.

Detect and report all disconnected components in the network.

For each connected component, return:

Its Minimum Spanning Tree (MST)

The total cost (latency)

Input Format:
List of computers (nodes): ["A", "B", "C", "D", "E", "F"]

List of weighted connections: [("A", "B", 3), ("A", "C", 1), ...]

Graph is undirected and weighted

 Output Format:
For each disconnected component:

List of edges in MST with weights

Total cost of that MST

Test Case 1 – Fully Connected Network

Computers: [A, B, C, D]
Connections:
A - B (1)
A - C (2)
B - C (2)
C - D (3)
Expected Output:
Component 1:
MST Edges: A-B(1), A-C(2), C-D(3)
Total Cost: 6

 Test Case 2 – Disconnected Network

Computers: [P, Q, R, S, T, U]
Connections:
P - Q (4)
Q - R (1)
S - T (3)
T - U (2)

Component 1:
MST Edges: Q-R(1), P-Q(4)
Total Cost: 5

Component 2:
MST Edges: T-U(2), S-T(3)
Total Cost: 5
*/

import java.util.*;

public class MST_usingPrims_components {

   static HashMap <Character, ArrayList<String[]>> adjs = new HashMap<>();
    static   HashMap <Character,Boolean> visited = new HashMap<>();
    public static void insert(String s,String d,String w)
    {
        char key=s.charAt(0);
        if(!adjs.containsKey(key))
            adjs.put(key,new ArrayList<String[]>());
        adjs.get(key).add(new String[] {d,w});

         key=d.charAt(0);
        if(!adjs.containsKey(key))
            adjs.put(key,new ArrayList<String[]>());
        adjs.get(key).add(new String[] {s,w});

    }
    public static void main(String[] args) {
        int n= 4;
        insert("p","q","4");
        insert("q","r","1");
        insert("s","t","3");
        insert("t","u","2");

//        for(char key: adjs.keySet())
//        {
//            for(String[] s:adjs.get(key))
//            {
//                System.out.println(key+" : "+ Arrays.toString((s)));
//            }
//        }
        for(char key: adjs.keySet())
            visited.put(key,false);

        int count=1;
        for(char key: visited.keySet())
        {

            if(!visited.get(key)) {
                System.out.println(count + " component");
                prims(key, count++);
            }
        }

    }
    static class Edge
    {
        char s,d;
        int w;
        Edge(char s,String d,String w)
        {
            this.s=s;
            this.d=d.charAt(0);
            this.w=Integer.parseInt(w);
        }
    }
    public static void prims(char s,int count)
    {

        PriorityQueue <Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w,b.w));
        int mst=0;
        pq.add(new Edge(s,"*","0"));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            if (visited.get(current.s))
                continue;
            //System.out.println(current.s);
            visited.put(current.s, true);
            if (current.d != '*') {
                System.out.printf("%c - %c : weight(%d)\n", current.d, current.s, current.w);
                mst += current.w;
            }

            for(String[] adj:adjs.get(current.s))
            {
                if(!visited.get(adj[0].charAt(0)))
                {
                    pq.add(new Edge(adj[0].charAt(0),current.s+"",adj[1]));
                }
            }
        }
        System.out.println("MST="+mst);
    }

}
