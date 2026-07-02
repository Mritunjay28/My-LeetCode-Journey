class Solution {
    int m=0;
    int n=0;
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m=grid.size();
        n=grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        int[][] best = new int[m][n];
        for (int[] row : best) {
            Arrays.fill(row, -1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[2]-a[2]);
        pq.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

       while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int i = curr[0];
            int j = curr[1];
            int currHealth = curr[2];

            // Skip outdated state
            if (currHealth < best[i][j]) continue;

            if (i == m - 1 && j == n - 1) {
                return true;
            }

            for (int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];

                if (x < 0 || x >= m || y < 0 || y >= n) continue;

                int newHealth = currHealth - grid.get(x).get(y);

                if (newHealth > 0 && newHealth > best[x][y]) {
                    best[x][y] = newHealth;
                    pq.offer(new int[]{x, y, newHealth});
                }
            }
        }

        return false;
    }
}