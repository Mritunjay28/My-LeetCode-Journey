class Solution {
    public int change(int amount, int[] coins) {
        // return f(0,amount,coins);
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                // take 
                int take = 0;
                if (coins[i] <= j) take = dp[i][j-coins[i]];
                // nottake
                int nottake = dp[i+1][j]; 

                dp[i][j] = take + nottake;
            }
        }

        return dp[0][amount];

    }

    // public int f(int i,int amount, int[] coins ){
    //     if(amount==0) return 1;
    //     if(i==coins.length) return 0;

    // // take 
    // int take =0;
    // if(coins[i] <= amount) take = f(i,amount-coins[i],coins);

    // int nottake = f(i+1,amount,coins);

    // return take+nottake;
    // }
}