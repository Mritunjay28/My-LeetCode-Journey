class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j] ) {
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

    void dfs(char[][] grid,int row,int col, boolean[][] visited ){
        if(visited[row][col]) return ;
        visited[row][col] = true;

        for(int[] dir : direction ){
            int x = row+dir[0];
            int y = col+dir[1];

            if(x>=0 && x <grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1') dfs(grid,x,y,visited);
        }

    }
}