class Solution {

    int[] parent;
    int[] rank;

    int find (int value){
        if(value==parent[value]) return value;
        return parent[value]=find(parent[value]);
    }

    boolean union(int x,int y){
        int xparent=find(x);
        int yparent=find(y);

        if(xparent==yparent) return true;

        if(rank[xparent]>rank[yparent]) parent[yparent]=xparent;
        else if(rank[xparent]<rank[yparent]) parent[xparent]=yparent;
        else {
            parent[xparent]=yparent;
            rank[yparent]++;
        }

        return false;
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length <n-1) return -1;
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        rank=new int[n];

        int component=n;
        for(int i=0;i<connections.length;i++){
            int x=connections[i][0] , y=connections[i][1];

            boolean alreadyunion= union(x,y);
            if(!alreadyunion) component--;
        }

        return component-1;
    }
}