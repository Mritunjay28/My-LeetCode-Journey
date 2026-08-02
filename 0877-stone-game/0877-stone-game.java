class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
    int[][] dp = new int[n][n];
    // dp[i][j]= max net score difference btw alice and bob can be achieve using piles[i....j]
    // goal dp[0][n-1] , if dp[0][n-1] >0 alice win;

    // transition state 
    // 2 option first , last 
    // if first then pick piles[i] , reamin piles [i+1 ... j] oppnent get advantage of dp[i+1][j]
    // so net gain dp[i][j] = piles[i] - dp[i+1][j]

    // if last then dp[i][j] = piles[j] - dp[i][j-1]

    // so dp[i][j] = Max(piles[i] - dp[i+1][j] , piles[j] - dp[i][j-1])

    // base case : i==j dp[i][j]=piles[i]


    for(int i=0;i<n;i++) dp[i][i] = piles[i];

    for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                int pickStart = piles[i] - dp[i + 1][j];
                int pickEnd = piles[j] - dp[i][j - 1];

                dp[i][j] = Math.max(pickStart, pickEnd);
            }
        }

        return dp[0][n - 1] > 0;
    }
}