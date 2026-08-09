class Solution {
    public int minFallingPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        // for(int i=0;i<grid[0].length;i++){
        //     min=Math.min(min,f(0,i,grid));
        // }
        // return min;

        int n = grid.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[n][i] = Integer.MAX_VALUE;
            dp[i][n] = Integer.MAX_VALUE;
            dp[n - 1][i] = grid[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int currmin = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    currmin = Math.min(currmin, dp[i + 1][k]);
                }

                dp[i][j] = grid[i][j] + currmin;
            }
        }

        for (int i = 0; i < n; i++) min = Math.min(min, dp[0][i]);

        return min;
    }

    // public int f(int i, int j, int[][] grid) {
    //     if (i >= grid.length || j < 0 || j >= grid[0].length)
    //         return Integer.MAX_VALUE;
    //     if (i == grid.length - 1)
    //         return grid[i][j];

    //     int min = Integer.MAX_VALUE;
    //     for (int k = 0; k < grid.length; k++) {
    //         if (k == j)
    //             continue;
    //         min = Math.min(min, f(i + 1, k, grid));
    //     }

    //     return grid[i][j] + min;
    // }
}