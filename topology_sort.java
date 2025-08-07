import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class topology_sort {
    static ArrayList<ArrayList<Integer>> adjs = new ArrayList<>();
    public static  void insert(int x,int y)
    {
        adjs.get(x).add(y);
    }
    public static void main(String[] args) {

        int n=6;
        for(int i=0;i<n;i++)
            adjs.add(new ArrayList<Integer>());

        insert(5,0);
        insert(5,2);
        insert(4,0);
        insert(4,1);
        insert(2,3);
        insert(3,1);
        System.out.println(Arrays.toString(topo(n)));

    }
    public static int[] topo(int n)
    {
        int degree[] = new int[n];

        for(int i=0;i<n;i++)
        {
            for(int in:adjs.get(i))
                degree[in]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int topo[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(degree[i]==0)
                queue.add(i);
        }
        int i=0;
        while(!queue.isEmpty())
        {
            int temp=queue.poll();
            topo[i++]=temp;

            for(int in:adjs.get(temp))
            {
                degree[in]--;
                if(degree[in]==0)
                    queue.add(in);
            }
        }
          return topo;
    }
}