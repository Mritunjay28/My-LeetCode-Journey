class Solution {
    public int maxProfit(int k, int[] arr) {
        // return f(0,1,k,prices); 
        int n = arr.length;
        int[][][] dp = new int[n + 1][2][k+1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j == 1) {
                        int buy = dp[i+1][0][l] - arr[i];
                        int skip = dp[i+1][1][l];

                        dp[i][j][l] = Math.max(buy, skip);
                    } else {
                        int sell = arr[i] + dp[i+1][1][l-1];
                        int skip = dp[i+1][0][l];

                        dp[i][j][l] = Math.max(sell, skip);
                    }
                }
            }
        }

        return dp[0][1][k];
    }

    public int f(int i, int buyallow, int k, int[] arr) {
        if (i == arr.length)
            return 0;
        if (k == 0)
            return 0;
        if (buyallow == 1) {
            int buy = f(i + 1, 0, k, arr) - arr[i];
            int skip = f(i + 1, 1, k, arr);

            return Math.max(buy, skip);
        } else {
            int sell = arr[i] + f(i + 1, 1, k - 1, arr);
            int skip = f(i + 1, 0, k, arr);

            return Math.max(sell, skip);
        }
    }
}