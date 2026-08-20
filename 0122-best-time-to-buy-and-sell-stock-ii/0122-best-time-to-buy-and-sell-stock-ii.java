class Solution {
    public int maxProfit(int[] arr) {
        // return f(0,1,prices);

        int n = arr.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    int buy = dp[i + 1][0] - arr[i];
                    int skip = dp[i + 1][1];

                    dp[i][j] = Math.max(skip, buy);
                } else {
                    int sell = arr[i] + dp[i + 1][1];
                    int skip = dp[i + 1][0];

                    dp[i][j] =  Math.max(skip, sell);
                }
            }
        }

        return dp[0][1];
    }

    public int f(int i, int buyAllow, int[] arr) {
        if (i == arr.length) {
            return 0;
        }
        if (buyAllow == 1) {
            int buy = f(i + 1, 0, arr) - arr[i];
            int skip = f(i + 1, buyAllow, arr);

            return Math.max(skip, buy);
        } else {
            int sell = arr[i] + f(i + 1, 1, arr);
            int skip = f(i + 1, 0, arr);

            return Math.max(skip, sell);
        }
    }
}