class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       // return f(0,0,obstacleGrid);
       int m=obstacleGrid.length;
       int n=obstacleGrid[0].length;
       int[][] dp = new int[m+1][n+1];

       if(obstacleGrid[m-1][n-1]==1) return 0;

       dp[m-1][n-1] = 1;
       for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(obstacleGrid[i][j]==1) continue;
            if(i==m-1 && j==n-1 ) continue;

            dp[i][j] += dp[i+1][j] + dp[i][j+1];
        }
       }

       return dp[0][0];
    }

    // public int f(int i,int j,int[][] grid){
    //     if(i>=grid.length || j>=grid[0].length ) return 0;
    //     if(grid[i][j]==1) return 0;
    //     if(i==grid.length-1 && j==grid[0].length-1 ) return 1;

    //     int count=0;
    //     count+=f(i+1,j,grid);
    //     count+=f(i,j+1,grid);

    //     return count;
    // }
}