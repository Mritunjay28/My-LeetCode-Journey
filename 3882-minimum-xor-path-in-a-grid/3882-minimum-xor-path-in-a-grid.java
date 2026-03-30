
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j] will store all possible XOR values to reach cell (i, j)
        HashSet<Integer>[][] dp = new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }

        dp[0][0].add(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = (i == 0 ? 1 : 0); j < n; j++) {
                if (i > 0) {
                    for (int x : dp[i - 1][j]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                }
                if (j > 0) {
                    for (int x : dp[i][j - 1]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                }
            }
        }

        // Find minimum XOR value in the last cell
        int min = Integer.MAX_VALUE;
        for (int val : dp[m - 1][n - 1]) {
            min = Math.min(min, val);
        }
        return min;
    }
}