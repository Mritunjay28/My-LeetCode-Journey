class Solution {
    int OFFSET = 5000;
    public int tallestBillboard(int[] rods) {
        // int ans = f(0, 0, rods);
        // return ans < 0 ? 0 : ans / 2;
        int sum = 0;
        for (int x : rods)
            sum += x;
        int n = rods.length;
        int[][] dp = new int[n + 1][10001];

        for (int i = 0; i <= 10000; i++) dp[n][i] = (int) -1e9;

        dp[n][0+OFFSET] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = -5000; j <= 5000; j++) {

                int take = (j + rods[i] <= 5000) ? rods[i] + dp[i + 1][j + rods[i] + OFFSET] : (int) -1e9;

                int nottake = (j - rods[i] >= -5000) ? rods[i] + dp[i + 1][j - rods[i] + OFFSET] : (int) -1e9;

                int skip = dp[i+1][j+OFFSET];

                dp[i][j+OFFSET] = Math.max(take, Math.max(nottake, skip));
            }
        }

        int ans = dp[0][0 + OFFSET];
        return ans < 0 ? 0 : ans / 2;
    }

    public int f(int i, int sum, int[] rods) {
        if (i == rods.length && sum == 0)
            return 0;
        if (i == rods.length)
            return (int) -1e9;

        int take = f(i + 1, sum + rods[i], rods) + rods[i];
        int nottake = f(i + 1, sum - rods[i], rods) + rods[i];
        int skip = f(i + 1, sum, rods);

        return Math.max(take, Math.max(nottake, skip));
    }
}
// +1,+2,-3,+7,-6
// 10-9 = 1;
// 