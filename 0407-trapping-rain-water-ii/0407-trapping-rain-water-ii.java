class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m= heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            p.offer(new int[]{heightMap[i][0],i,0});
            visited[i][0]=true;

            p.offer(new int[]{heightMap[i][n-1],i,n-1});
            visited[i][n-1]=true;
        }

        for(int i=0;i<n;i++){
            p.offer(new int[]{heightMap[0][i],0,i});
            visited[0][i]=true;

            p.offer(new int[]{heightMap[m-1][i],m-1,i});
            visited[m-1][i]=true;
        }


        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        int water=0;

        while(!p.isEmpty()){
            int[] curr = p.poll();
            int height=curr[0];
            int i=curr[1];
            int j=curr[2];

            for(int[] dir : direction){
                int newrow= i+dir[0];
                int newcol= j+dir[1];

                if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && visited[newrow][newcol]!=true){
                    water+=Math.max(height-heightMap[newrow][newcol],0);
                    visited[newrow][newcol]=true;
                    p.offer(new int[]{Math.max(height,heightMap[newrow][newcol]),newrow,newcol});
                }
            }
        }

        return water;
    }
}