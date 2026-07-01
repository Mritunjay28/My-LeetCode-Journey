class Solution {
    int min = 10000000;
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[] { i, j });
                    dist[i][j] = 0;
                }
            }
        }

        int l = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] d : dir) {
                    int x_ = x + d[0];
                    int y_ = y + d[1];

                    if (x_ >= 0 && x_ < n && y_ >= 0 && y_ < n && grid.get(x_).get(y_) == 0 && dist[x_][y_] == -1) {
                        dist[x_][y_] = l;
                        q.add(new int[] { x_, y_ });
                    }
                }
            }
            l++;
        }

        l = 0;
        int r = 0;
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r = Math.max(r, dist[i][j]);
            }
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValidSafeness(dist, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private boolean isValidSafeness(int[][] grid, int minSafeness) {
        int n = grid.length;

        if (grid[0][0] < minSafeness || grid[n - 1][n - 1] < minSafeness) {
            return false;
        }

        Queue<int[]> traversalQueue = new LinkedList<>();
        traversalQueue.add(new int[] { 0, 0 });
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!traversalQueue.isEmpty()) {
            int[] curr = traversalQueue.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return true;
            }

            for (int[] d : dir) {
                int di = curr[0] + d[0];
                int dj = curr[1] + d[1];

                if (di >= 0 && dj >= 0 && di < n && dj < n && !visited[di][dj] && grid[di][dj] >= minSafeness) {
                    visited[di][dj] = true;
                    traversalQueue.add(new int[] { di, dj });
                }
            }
        }

        return false;
    }

}