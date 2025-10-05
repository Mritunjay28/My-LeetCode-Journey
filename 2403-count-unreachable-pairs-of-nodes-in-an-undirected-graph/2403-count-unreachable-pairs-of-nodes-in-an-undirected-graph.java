class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    void union(int x,int y){
        int xparent=find(x);
        int yparent=find(y);

        if(xparent==yparent) return ;

        if(rank[xparent]>rank[yparent]) parent[yparent]=xparent;
        else if(rank[yparent]>rank[xparent]) parent[xparent]=yparent;
        else{
            parent[xparent]=yparent;
            rank[yparent]++;
        }
    }


    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        for(int i =0;i<n;i++) parent[i]=i;
        rank = new int[n];

        for(int i=0;i<edges.length;i++) union(edges[i][0],edges[i][1]);

        long count=0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++)  map.put(find(i),map.getOrDefault(find(i),0)+1);

        ArrayList<Integer> arr =new ArrayList<>();
        for (Integer val : map.values()) {
        arr.add(val);
        }

        if(arr.size()==1) return 0;

        int total=n;
        for(int size : arr) {
            total -= size;
            count += (long) size * total;
        }

        return count;
    }
}