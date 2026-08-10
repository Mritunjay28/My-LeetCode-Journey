class Solution {
    int[][] dp;

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        dp = new int[n + 1][3001];
        //    for(int[] d :dp) Arrays.fill(d,-1);
        //     return f(0,stones,0);

        for (int i = 0; i < 3001; i++)
            dp[n][i] = i;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 3001; j++) {
                int take = (j + stones[i] <= 3000) ? dp[i + 1][j + stones[i]] : Integer.MAX_VALUE;
                int nottake = dp[i + 1][Math.abs(j - stones[i])];

                dp[i][j] = Math.min(take, nottake);
            }
        }

        return dp[0][0];
    }

    // public int f(int i, int[] stones, int weight) {
    //     if (i == stones.length)
    //         return Math.abs(weight);
    //     if (dp[i][Math.abs(weight)] != -1)
    //         return dp[i][Math.abs(weight)];
    //     int take = f(i + 1, stones, weight + stones[i]);
    //     int nottake = f(i + 1, stones, weight - stones[i]);

    //     return dp[i][Math.abs(weight)] = Math.min(take, nottake);
    // }
}

/*
given that if(x<=y) we get y-x
thne if we smash it to z thne it like z-y+x

so basically assigning +ve ,-ve value to values , so to minimize smallest wait try to foem subset with sum/;
for 0;


*/