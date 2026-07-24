class Solution {
    int[] rank;
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;

        for(int[] edge : edges){
            int x = edge[0]-1;
            int y = edge[1]-1;

            if(union(x,y)) return edge;
        }

        return new int[0];
    }

    public int find(int i){
        if(i==parent[i]) return i;

        return parent[i] = find(parent[i]);
    }


    public boolean union(int x , int y){
        int xparent = find(x);
        int yparent = find(y);

        if(xparent==yparent) return true;

        if(rank[xparent]> rank[yparent]){
            parent[yparent]=xparent;
        }
        else if(rank[yparent]> rank[xparent]){
            parent[xparent]=yparent;
        }
        else{
            parent[yparent]=xparent;
            rank[xparent]++;
        }

        return false;
    }
}

/*
Can be done with simple checking all edges remove one by one using dfs and visited as already submited 

but if we try to do it with dsu then 
when extra edge will be add they will have same parent so as we get this that both points have same parent then return that edge as their is only extra edges then their cannot be more edges to right of inputs .

*/