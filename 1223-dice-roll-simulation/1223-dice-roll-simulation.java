class Solution {
     static final int MOD = 1_000_000_007;
    public int dieSimulator(int n, int[] rollMax) {
        //return f(n,rollMax,-1,0);
        int[][][] dp = new int[n + 1][6][16];
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <16; j++) {
                dp[0][i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <16; k++) {
                    long sum = 0;
                    for (int l = 0; l < 6; l++) {
                        if (l == j) {
                            if (k < rollMax[l])  sum += dp[i-1][l][k+1];
                        } else  sum += dp[i-1][l][1];
                        sum %= MOD;
                    }
                    dp[i][j][k]= (int)sum;
                }
            }
        }

         long ans = 0;

        // First roll can be any face
        for (int j = 0; j < 6; j++) {
            ans += dp[n - 1][j][1];
            ans %= MOD;
        }

        return (int) ans;
    }

    public int f(int n, int[] arr, int last, int count) {
        if (n == 0)
            return 1;
        int sum = 0;
        for (int j = 0; j < 6; j++) {
            if (j == last) {
                if (count < arr[j])
                    sum += f(n - 1, arr, j, count + 1);
            } else
                sum += f(n - 1, arr, j, 1);
        }
        return sum;
    }
}