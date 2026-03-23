class Solution {
    int pre=0;
    public int islandPerimeter(int[][] grid) {
        int m = grid.length , n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        boolean first = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,visited);
                    first=true;
                    break;
                } 
            }
            if(first) break;
        }

        return pre;
    }

    public void dfs(int i,int j ,int[][] grid,boolean[][] visited){
        int m = grid.length , n=grid[0].length;
        visited[i][j] = true;

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        for(int[] d : dir){
            int x = i+d[0] , y =d[1]+j;

            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1 && !visited[x][y]){
                dfs(x,y,grid,visited);
            }
            else if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1 && visited[x][y]){
               continue;
            }
            else{
                pre++;
            } 
        }
    }
}