class Solution {
     int m ,n;
    public boolean containsCycle(char[][] grid) {
        m= grid.length;
        n=grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && dfs(grid,i,j,i,j,1,visited)) return true;
            }
        }

        return false;
    }

    int[][] direc = {{0,1},{1,0},{-1,0},{0,-1}};

    public boolean dfs(char[][] grid,int i,int j,int a,int b,int l, boolean[][] visited){
        visited[i][j]=true;

        for(int[] dir :direc){
            int x = i+dir[0] , y = j+dir[1];
            if(x==a && y==b && l>=4) {
                return true;
            }
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==grid[i][j] && !visited[x][y]){
                if(dfs(grid,x,y,a,b,l+1,visited)) return true;
            }
        }
        visited[i][j]=false;

        return false;
    }
}
