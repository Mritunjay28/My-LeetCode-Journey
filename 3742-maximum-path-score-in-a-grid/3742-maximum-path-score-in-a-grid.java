class Solution {
    public int maxPathScore(int[][] grid, int k) {
        Integer dp[][][] = new Integer[grid.length][grid[0].length][k+1];
        int ans = helper(0,0,0,grid,k,dp);
        if ( ans == Integer.MIN_VALUE)return -1;
        return ans;
    }


    public int helper(int row,int col,int cost,int [][] grid,int maxCost,Integer dp[][][]){

        if(row>=grid.length || col >= grid[0].length)return Integer.MIN_VALUE;
        
        int curCost = 0;
        
        if(grid[row][col]>0) curCost = 1;
        curCost = cost+curCost; 
        
        if(curCost>maxCost)return Integer.MIN_VALUE;

        if(row == grid.length - 1 && col == grid[0].length-1 )return grid[row][col]; 
        if(dp[row][col][curCost] != null)return dp[row][col][curCost];
        
        int right =  helper(row,col+1,curCost,grid,maxCost,dp);
        int down = helper(row+1,col,curCost,grid,maxCost,dp);

        if(right == Integer.MIN_VALUE && down == Integer.MIN_VALUE)return dp[row][col][curCost]= right;
        
        return dp[row][col][curCost]= grid[row][col]+Math.max(right,down);
    }
}