class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 0 ;
        grid[i][j]=0;

        int x = dfs(grid,i+1,j);
        int y = dfs(grid,i,j+1);
        int x_ = dfs(grid,i-1,j);
        int y_ = dfs(grid,i,j-1);

        return x+y+x_+y_+1 ;
    }
}