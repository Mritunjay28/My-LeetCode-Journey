class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] memo = new int[n][n][n][n];
        for (int[][][] block3D : memo) {
            for (int[][] matrix2D : block3D) {
                for (int[] row : matrix2D) {
                    Arrays.fill(row, -1);
                }
            }
        }

        int ans = f(0, 0, 0, 0, grid, memo); // 2 robot travelling at same time 
        return Math.max(0, ans); // if ans <0 then no psth btw (0,0) , (n-1,n-1)
    }

    public int f(int r1, int c1, int r2, int c2, int[][] grid,int[][][][] memo) {
        int n = grid.length;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        
        if(memo[r1][c1][r2][c2]!=-1) return memo[r1][c1][r2][c2];

        if (r1 == n - 1 && c1 == n - 1) { // both robot each at same time
            return grid[n - 1][n - 1];
        }

        int cherries = 0;
        if (r1 == r2 && c1 == c2) { // Both robots landed on the same cell, collect the cherry only once
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }

        int rr = f(r1, c1 + 1, r2, c2 + 1, grid,memo); // Robot 1 Right, Robot 2 Right
        int dd = f(r1 + 1, c1, r2 + 1, c2, grid,memo); // Robot 1 Down, Robot 2 Down
        int rd = f(r1, c1 + 1, r2 + 1, c2, grid,memo); // Robot 1 Right, Robot 2 Down
        int dr = f(r1 + 1, c1, r2, c2 + 1, grid,memo); // Robot 1 Down, Robot 2 Right

        int maxMove = Math.max(Math.max(rr, dd), Math.max(rd, dr));

        if (maxMove == Integer.MIN_VALUE) return memo[r1][c1][r2][c2] = Integer.MIN_VALUE;

        return memo[r1][c1][r2][c2] = cherries + maxMove;
    }
}