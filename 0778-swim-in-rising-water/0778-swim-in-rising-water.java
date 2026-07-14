class Solution {
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        int[][] dist = new int[n][n];
        for(int[] x :dist) Arrays.fill(x,n*n);

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        q.add(new int[]{0,0,grid[0][0]});
        dist[0][0] = grid[0][0];

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0]==n-1 && curr[1]==n-1) return curr[2];

            if(curr[2] > dist[curr[0]][curr[1]]) continue;

            for(int[] d : dir){
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];

                if(x<0 || x>n-1 || y<0 || y>n-1) continue;

                if(dist[x][y] > Math.max(curr[2],grid[x][y])){
                    dist[x][y] = Math.max(curr[2],grid[x][y]);
                    q.add(new int[] {x,y,dist[x][y]});
                }
            }
           
        }

        return -1;
    }
}