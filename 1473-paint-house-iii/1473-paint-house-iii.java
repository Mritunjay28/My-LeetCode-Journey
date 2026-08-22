class Solution {
    public int minCost(int[] houses, int[][] cost, int x, int y, int target) {
        // return f(0, -1, houses, cost, target);

        int n = houses.length;

        int[][][] dp = new int[n + 1][target + 1][y+1];

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <= y; j++) {
                dp[n][i][j] = (int) 1e9;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = target; j >= 0; j--) {
                for (int k = 0; k <= y; k++) {
                    if (houses[i] != 0) {
                        if (k == houses[i]) {
                            dp[i][j][k] =  dp[i+1][j][k];
                        } else
                           dp[i][j][k] = (j - 1 >= 0) ? dp[i + 1][j - 1][houses[i]] : (int) 1e9;
                    } else {
                        // try all colour we now and take smallest value 
                        int min = (int) 1e9;
                       
                        for (int l = 0; l < cost[i].length; l++) {
                            if (l+1 == k)
                                min = Math.min(min, cost[i][l] + dp[i+1][j][l+1]);
                            else{
                                if(j-1<0) {
                                    min=Math.min(min,(int)1e9);
                                }
                                else min = Math.min(min, cost[i][l] + dp[i+1][j-1][l+1]);
                            }    
                        }

                        dp[i][j][k] = min;
                    }
                }
            }
        }

       int ans = dp[0][target][0];
        return ans >= (int) 1e9 ? -1 : ans;
    }

    public int f(int i, int prev, int[] arr, int[][] cost, int target) {
        if (target < 0)
            return (int) 1e9;
        if (i == arr.length && target == 0)
            return 0;
        if (i == arr.length && target != 0)
            return (int) 1e9;

        if (arr[i] != 0) {
            if (prev + 1 == arr[i]) {
                return f(i + 1, prev, arr, cost, target);
            } else
                return f(i + 1, arr[i] - 1, arr, cost, target - 1);
        } else {
            // try all colour we now and take smallest value 
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < cost[i].length; j++) {
                if (j == prev)
                    min = Math.min(min, cost[i][j] + f(i + 1, j, arr, cost, target));
                else
                    min = Math.min(min, cost[i][j] + f(i + 1, j, arr, cost, target - 1));
            }

            return min;
        }
    }
}