class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // Mark 1s as unvisited
                }
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                        mat[r][c] = level; 
                        q.add(new int[]{r, c});
                    }
                }
            }
            level++;
        }

        return mat;
    }
}