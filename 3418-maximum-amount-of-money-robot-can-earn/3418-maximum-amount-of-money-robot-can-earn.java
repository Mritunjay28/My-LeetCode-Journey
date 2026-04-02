class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m + 1][n + 1][3];
        // not neutralize , 1 neutralize ,2 netralize

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = -1_000_000_000;
            }
        }

        dp[0][1][0] = dp[1][0][0] = 0;
        dp[0][1][1] = dp[1][0][1] = 0;
        dp[0][1][2] = dp[1][0][2] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int val = coins[i - 1][j - 1];
                // not neutralize 
                if (val >= 0) {
                    dp[i][j][0] = val + Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                    dp[i][j][1] = val + Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
                    dp[i][j][2] = val + Math.max(dp[i - 1][j][2], dp[i][j - 1][2]);
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) - Math.abs(val);
                    dp[i][j][1] = Math.max(dp[i - 1][j][0],
                            Math.max(dp[i][j - 1][0], Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) - Math.abs(val)));
                    dp[i][j][2] = Math.max(dp[i - 1][j][1],
                            Math.max(dp[i][j - 1][1], Math.max(dp[i - 1][j][2], dp[i][j - 1][2]) - Math.abs(val)));
                }
            }
        }

        return Math.max(dp[m][n][0], Math.max(dp[m][n][1], dp[m][n][2]));
    }
}