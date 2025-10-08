class Solution {
    int n;
    public int swimInWater(int[][] grid) {
         n= grid.length;
        int s=0,e=n*n,ans=-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            boolean[][] visited = new boolean[n][n];
            if(bfs(mid,grid,visited)){
                ans= mid;
                e=mid-1;
            }
            else s= mid+1;
        }
        return ans;
    }

    private boolean bfs(int maxtime ,int[][] grid, boolean[][] visited){
         Queue<int[]> q = new LinkedList<>();
         if(grid[0][0] > maxtime) return false;
        q.offer(new int[] {0,0});
        visited[0][0]=true;

        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            int[] curr = q.poll(); 
            int row = curr[0];
            int col  =curr[1];
            

            if(row==n-1 && col==n-1) return true;

            for(int[] dir : direction){
                int x= row+dir[0];
                int y= col+dir[1];

                if(x>=0 && x<n && y>=0 && y<n && !visited[x][y] && grid[x][y]<= maxtime){
                    q.offer(new int[] {x,y});
                    visited[x][y]=true;
                }
            }
        }

        return false;
    }
}