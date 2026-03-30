class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Since m * n <= 1000, we can map (i, j) to a single index: i * n + j
        // dp[cell_index][xor_value] = true if xor_value is reachable at cell_index
        boolean[][] dp = new boolean[m * n][1024];

        // Base case: Starting point (0, 0)
        dp[0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currIdx = i * n + j;
                int val = grid[i][j];

                // If we are not at the start, we check neighbors
                if (i == 0 && j == 0) continue;

                // Check Top neighbor (i-1, j)
                if (i > 0) {
                    int topIdx = (i - 1) * n + j;
                    for (int k = 0; k < 1024; k++) {
                        if (dp[topIdx][k]) {
                            dp[currIdx][k ^ val] = true;
                        }
                    }
                }

                // Check Left neighbor (i, j-1)
                if (j > 0) {
                    int leftIdx = i * n + (j - 1);
                    for (int k = 0; k < 1024; k++) {
                        if (dp[leftIdx][k]) {
                            dp[currIdx][k ^ val] = true;
                        }
                    }
                }
            }
        }

        // Find the minimum XOR value reachable at the last cell (m-1, n-1)
        int lastIdx = (m * n) - 1;
        for (int k = 0; k < 1024; k++) {
            if (dp[lastIdx][k]) {
                return k;
            }
        }

        return -1; 
    }
}