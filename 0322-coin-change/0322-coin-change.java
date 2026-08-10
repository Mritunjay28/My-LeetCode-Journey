class Solution {
    public int coinChange(int[] coins, int amount) {
        // int ans = f(0, coins, amount);
        // return ans >= 1e9 ? -1 : ans;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 1; i <= amount; i++)
            dp[n][i] = (int) 1e9;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                // take 
                int take = (int) 1e9;
                if (coins[i] <= j)
                    take = 1 + dp[i][j - coins[i]];

                // notake 
                int nottake =  dp[i+1][j];

                dp[i][j] =  Math.min(take, nottake);
            }
        }

        int ans = dp[0][amount];
        return ans >= 1e9 ? -1 : ans;
    }

    // public int f(int i,int[] coins, int amount){
    //     if(amount==0) return 0;
    //     if(i==coins.length) return (int) 1e9;
    // // take 
    // int take =(int) 1e9;
    // if(coins[i]<=amount) take = 1+f(i,coins,amount-coins[i]);

    // // notake 
    // int nottake = f(i+1,coins,amount);

    // return Math.min(take,nottake);
    // }
}