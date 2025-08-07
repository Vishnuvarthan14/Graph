public class disjoint {
    int rank[];
    int parent[];
    disjoint(int n)
    {
        rank = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++)
            parent[i] = i;
    }
    public int find(int x)
    {
        int root=parent[x];

        if(root!=parent[root])
            return parent[x] = find(root);
        return root;
    }

    public void union(int x,int y)
    {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot==yRoot)
            return;
        if(rank[xRoot]>rank[yRoot])
        {
            parent[yRoot]=xRoot;
        }
        else if(rank[xRoot]<rank[yRoot])
        {
            parent[xRoot] = yRoot;
        }
        else
        {
            parent[yRoot]=xRoot;
            rank[xRoot]++;
        }
    }

}
