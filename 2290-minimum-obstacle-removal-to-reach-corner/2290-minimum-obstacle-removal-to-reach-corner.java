class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];

        for(int[] row : dist) Arrays.fill(row,Integer.MAX_VALUE);

        dist[0][0]=0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[2] - b[2]);

        q.add(new int[] {0,0,0});

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int broken = curr[2];

            if(i==m-1 && j==n-1) return broken;

            if(broken > dist[i][j]) continue;

            for(int[] d : dir){

                int x = i+d[0];
                int y = j+d[1];

                if(x<0 || x>m-1 || y<0 || y>n-1) continue;

                if(grid[x][y]==0 && broken < dist[x][y]) {
                    dist[x][y] = broken;
                    q.add(new int[] {x,y,broken});
                }
                
                if(grid[x][y]==1 && broken +1 < dist[x][y]){
                    dist[x][y] = broken+1;
                    q.add(new int[] {x,y,broken+1});
                }
            }
        }

        return -1;
    }
}