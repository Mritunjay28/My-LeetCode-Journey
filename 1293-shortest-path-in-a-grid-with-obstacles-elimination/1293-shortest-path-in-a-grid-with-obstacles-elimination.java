class Solution {
    class State {
        int i;
        int j;
        int k;

        State(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        Queue<State> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][k + 1];

        q.add(new State(0, 0, k));
        visited[0][0][k] = true;
        int step = 0;
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                State temp = q.poll();
                int r = temp.i;
                int c = temp.j;
                int remk = temp.k;

                if (r == n - 1 && c == m - 1) return step;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    int newk = remk;

                    if (nr >= 0 && nr < n && nc < m && nc >= 0) {
                        if (grid[nr][nc] == 1) newk--;
                        if ( newk >= 0 &&!visited[nr][nc][newk] ) {
                            visited[nr][nc][newk] = true;
                            q.add(new State(nr, nc, newk));
                        }
                    }
                }
            }
            step++;
        }

        return -1;

    }
}