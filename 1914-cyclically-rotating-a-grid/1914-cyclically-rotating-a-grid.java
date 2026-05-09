class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        for (int t = 0; t < Math.min(m, n) / 2; t++) {
            int top = t, left = t;
            int bottom = m - 1 - t;
            int right = n - 1 - t;

            List<Integer> value = new ArrayList<>();

            // top row
            for (int i = left; i <= right; i++) {
                value.add(grid[top][i]);
            }

            // right column
            for (int i = top + 1; i <= bottom - 1; i++) {
                value.add(grid[i][right]);
            }

            // bottom row
            for (int i = right; i >= left; i--) {
                value.add(grid[bottom][i]);
            }

            // left column
            for (int i = bottom - 1; i >= top + 1; i--) {
                value.add(grid[i][left]);
            }

            int size = value.size();
            int idx = k % size;

            // put back top row
            for (int i = left; i <= right; i++) {
                grid[top][i] = value.get(idx);
                idx = (idx + 1) % size;
            }

            // put back right column
            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = value.get(idx);
                idx = (idx + 1) % size;
            }

            // put back bottom row
            for (int i = right; i >= left; i--) {
                grid[bottom][i] = value.get(idx);
                idx = (idx + 1) % size;
            }

            // put back left column
            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = value.get(idx);
                idx = (idx + 1) % size;
            }
        }

        return grid;
    }
}