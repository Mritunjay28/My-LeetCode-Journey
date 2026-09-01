class Solution {
    class State {
        int r, c, mask, cap;
        State(int r, int c, int mask, int cap) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.cap = cap;
        }
    }

    public int minMoves(String[] arr, int energy) {
        int n = arr.length, m = arr[0].length();
        int sr = -1, sc = -1;
        List<int[]> litters = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = arr[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }

        int targetMask = (1 << litters.size()) - 1;
        if (targetMask == 0) return 0;

        int[][][] visited = new int[n][m][1 << litters.size()];
        for (int[][] mat : visited) {
            for (int[] row : mat) Arrays.fill(row, -1);
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(sr, sc, 0, energy));
        visited[sr][sc][0] = energy;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                State curr = q.poll();
                if (curr.mask == targetMask) return moves;
                if (curr.cap == 0) continue;

                for (int[] d : dirs) {
                    int nr = curr.r + d[0], nc = curr.c + d[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int nextMask = curr.mask;
                    for (int id = 0; id < litters.size(); id++) {
                        if (litters.get(id)[0] == nr && litters.get(id)[1] == nc) {
                            nextMask |= (1 << id);
                            break;
                        }
                    }

                    int nextCap = (arr[nr].charAt(nc) == 'R') ? energy : curr.cap - 1;

                    if (nextCap > visited[nr][nc][nextMask]) {
                        visited[nr][nc][nextMask] = nextCap;
                        q.add(new State(nr, nc, nextMask, nextCap));
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}