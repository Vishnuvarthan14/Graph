import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
   static class pairs
    {
        int v;
        int p;
        int w;
        pairs(int v,int p,int w)
        {
            this.v =v;
            this.p=p;
            this.w=w;
        }
    }

    public static void main(String[] args) {
        int n=5;
        ArrayList <ArrayList<int[]>> adjs = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjs.add(new ArrayList<int[]>());
        }

        adjs.get(0).add(new int[] {1,2});
        adjs.get(0).add(new int[] {3,6});

        adjs.get(1).add(new int[] {0,2});
        adjs.get(1).add(new int[] {2,3});
        adjs.get(1).add(new int[] {3,8});
        adjs.get(1).add(new int[] {4,5});

        adjs.get(2).add(new int[] {1,3});
        adjs.get(2).add(new int[] {4,7});

        adjs.get(3).add(new int[] {0,6});
        adjs.get(3).add(new int[] {1,8});

        adjs.get(4).add(new int[] {1,5});
        adjs.get(4).add(new int[] {2,7});

        prims(adjs,n);
    }
    public static void prims(ArrayList<ArrayList<int[]>> adjs,int n)
    {
        boolean visited[] = new boolean[n];
        PriorityQueue <pairs> pq = new PriorityQueue<>((a,b)->(Integer.compare(a.w,b.w)));
        int sum=0;
        pq.offer(new pairs(0,-1,0));
        while(!pq.isEmpty())
        {
            pairs current = pq.poll();
            if(visited[current.v])
                continue;

            if(current.p!=-1)
            {
                System.out.printf("%d - %d weight : %d\n",current.p,current.v,current.w);
                sum+= current.w;
            }
            visited[current.v]=true;

            for(int[] adj:adjs.get(current.v))
            {
                if(!visited[adj[0]])
                    pq.offer(new pairs(adj[0],current.v,adj[1]));
            }
        }
        System.out.printf("Total weight of MST : %d",sum);
    }
}
