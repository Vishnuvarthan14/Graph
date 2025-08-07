import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims {
        static class Edge
        {
            int s,p,w;
            Edge(int s,int p,int w)
            {
                this.w=w;
                this.p=p;
                this.s=s;
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cities =sc.nextLine();
        int n=cities.split(" ").length;

        String [] path = sc.nextLine().split(" ");

        ArrayList<ArrayList<int[]>> adjs = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adjs.add(new ArrayList<int[]>());
        }

        for(String s:path)
        {
            int  sr=s.charAt(0)-'A';
            int des=s.charAt(2)-'A';
            int we=Integer.parseInt(s.substring(4));
            adjs.get(sr).add(new int[] {des,we});
        }

//        for(int i=0;i<n;i++)
//        {
//            for(int j=0;j<adjs.get(i).size();j++)
//                System.out.println(i+" : "+ Arrays.toString(adjs.get(i).get(j)));
//        }

        System.out.println(prims_implementation(adjs,n));
    }

    public static int prims_implementation(ArrayList<ArrayList<int []>> adjs,int n)
    {
        boolean visited[] = new boolean[n];
        PriorityQueue <Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w,b.w));
        int mst=0;
        pq.offer(new Edge(0,-1,0));
        while (!pq.isEmpty())
        {
            Edge current = pq.poll();
            if(visited[current.s])
                continue;

            visited[current.s]=true;

            if(current.p!=-1)
            {
                System.out.printf("%c - %c -> weight : %d\n",(char)(current.p+'A'),(char)(current.s+'A'),current.w);
                mst+= current.w;
            }

            for(int[] adj:adjs.get(current.s))
            {
                if(!visited[adj[0]])
                {
                    pq.offer(new Edge(adj[0], current.s, adj[1]));
                }
            }
        }
        return mst;
    }
}
