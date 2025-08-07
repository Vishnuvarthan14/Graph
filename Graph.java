import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Graph(int n)
    {
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> temp =new ArrayList<>();
            list.add(temp);
        }
    }

    public void addEdges(int u,int v)
    {
        list.get(u).add(v);
        list.get(v).add(u);
    }
    public ArrayList<ArrayList<Integer>>getAdjs()
    {
        return list;
    }
    public void bfs(int v)
    {
        System.out.println();
        Queue <Integer> que = new LinkedList<>();
        boolean visited[] = new boolean[list.size()];
        que.add(v);
        visited[v]=true;

        while(!que.isEmpty())
        {
            int a=que.remove();
            System.out.print(a+" ");
            for(int i=0;i<list.get(a).size();i++)
            {
                int av = list.get(a).get(i);
                if(!visited[av])
                {
                    que.add(av);
                    visited[av]=true;
                }
            }
        }
    }

    public void DFS(int v)
    {
        System.out.println();
        Stack <Integer> stack = new Stack<>();
        boolean visited[] = new boolean[list.size()];

        stack.push(v);
        visited[v]=true;

        while(!stack.isEmpty())
        {
            int vertex= stack.pop();
            System.out.print(vertex+" ");

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
    }

    public void display()
    {
        for(int i=0;i<list.size();i++){
        System.out.printf("Elemnets in the list %d : ",i);
        System.out.println(list.get(i));
          }
    }
}
