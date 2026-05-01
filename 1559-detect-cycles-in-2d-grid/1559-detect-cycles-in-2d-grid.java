class Solution {
     int m ,n;
      int[][] count;
    public boolean containsCycle(char[][] grid) {
        m= grid.length;
        n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        count = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && dfs(grid,i,j,-1,-1,visited)) return true;
            }
        }

        return false;
    }

    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public boolean dfs(char[][] grid, int i, int j, int pi, int pj, boolean[][] visited) {
        visited[i][j] = true;

        for(int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(grid[x][y] != grid[i][j]) continue;

           
            if(visited[x][y] && !(x == pi && y == pj)) return true;

            if(!visited[x][y]) {
                if(dfs(grid, x, y, i, j, visited)) return true;
            }
        }
        return false;
    }
}
