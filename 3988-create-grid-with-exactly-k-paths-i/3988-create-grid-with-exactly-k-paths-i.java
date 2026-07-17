class Solution {
    public String[] createGrid(int m, int n, int k) {
        String[] grid = new String[m];
        Arrays.fill(grid, ".".repeat(n));

        if (backtrack(grid, m, n, 0, k))
            return grid;

        return new String[0];
    }

    public boolean backtrack(String[] grid, int m, int n, int idx, int k) {

        int[][] dp = paths(m, n, grid);
        int total = dp[m - 1][n - 1];

        if (total == k)
            return true;

        if (total < k)
            return false;

        if (idx == m * n)
            return false;

        int row = idx / n;
        int col = idx % n;

        if ((row == 0 && col == 0) || (row == m - 1 && col == n - 1)) {
            return backtrack(grid, m, n, idx + 1, k);
        }

        // Place obstacle
        char[] chars = grid[row].toCharArray();
        chars[col] = '#';
        grid[row] = new String(chars);

        if (backtrack(grid, m, n, idx + 1, k))
            return true;

        // Backtrack
        chars = grid[row].toCharArray();
        chars[col] = '.';
        grid[row] = new String(chars);

        // Do not place obstacle
        if (backtrack(grid, m, n, idx + 1, k))
            return true;

        return false;
    }

    public int[][] paths(int m, int n, String[] grid) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i].charAt(j) != '#') {

                    if (i != 0 && j != 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else {
                        if (i == 0 && j != 0) {
                            dp[i][j] = dp[i][j - 1];
                        }
                        if (i != 0 && j == 0) {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }

        return dp;
    }
}