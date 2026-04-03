class Solution {
   public int largestIsland(int[][] grid) {
    int n = grid.length;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2; // Start IDs at 2 (since 0 and 1 are default grid values)
        int maxArea = 0;

        // Phase 1: Map all islands and store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSizes.put(islandId, size);
                    maxArea = Math.max(maxArea, size);
                    islandId++;
                }
            }
        }

        // Phase 2: Iterate over the grid again to test flipping 0s
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    int currentSum = 1; // The flipped 0
                    Set<Integer> seenIslands = new HashSet<>();

                    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                    
                    for (int[] d : dirs) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        // If neighbor is an island piece (ID >= 2), add its ID to the set
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] >= 2) {
                            seenIslands.add(grid[ni][nj]);
                        }
                    }

                    // Sum up the areas of the unique neighboring islands
                    for (int id : seenIslands) {
                        currentSum += islandSizes.get(id);
                    }
                    
                    maxArea = Math.max(maxArea, currentSum);
                }
            }
        }

        return hasZero ? maxArea : n * n; // Handle the all-1s edge case
    }

    private int dfs(int[][] grid, int r, int c, int id) {
        int n = grid.length;
        
        // If out of bounds or NOT an unvisited land piece (1), stop.
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = id; // Mark as visited with the unique ID
        int size = 1;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : dirs) {
            size += dfs(grid, r + d[0], c + d[1], id);
        }

        return size;
    }
}