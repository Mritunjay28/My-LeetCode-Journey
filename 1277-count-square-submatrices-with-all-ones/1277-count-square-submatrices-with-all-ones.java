class Solution {
    int sum = 0;

    //   int[][] dp;
    public int countSquares(int[][] matrix) {
        sum = 0;
        // dp = new int[matrix.length][matrix[0].length];
        // for(int[] d : dp){
        //     Arrays.fill(d,-1);
        // }
        // f(0,0,matrix);
        // return sum;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) continue;

                int right = dp[i][j+1];
                int down = dp[i+1][j];
                int downRight = dp[i+1][j+1];

                int min = Math.min(right, Math.min(down, downRight));
                sum += min + 1;
                dp[i][j] = min + 1;
            }
        }

        return sum;
    }

    // public int f(int i,int j,int[][] matrix){
    //     if(i>=matrix.length || j>=matrix[0].length) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    // int right = f(i,j+1,matrix);
    // int down = f(i+1,j,matrix);
    // int downRight = f(i+1,j+1,matrix);

    // if(matrix[i][j]==0) return dp[i][j]=0;

    // int min = Math.min(right,Math.min(down,downRight));
    // sum+=min+1;
    // return dp[i][j]=min+1;
    // }
}