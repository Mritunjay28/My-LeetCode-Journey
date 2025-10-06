class Solution {
    public int findMaxFish(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0) max=Math.max(max,dfs(grid,i,j));
            }
        }
        return max;
    }

    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    private int dfs(int[][] grid,int x,int y){
        int total = grid[x][y];
        grid[x][y]=0;
        for(int[] dir : direction){
            int i = x+dir[0];
            int j= y+dir[1];

            if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]>0) total+= dfs(grid,i,j);
        }

        return total;
    }
}