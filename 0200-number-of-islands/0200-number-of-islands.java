class Solution {
    public int numIslands(char[][] grid) {
        int m =grid.length,n=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean [m][n];

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    bfs(i,j,grid,visited);
                }
            }
        }

        return count;
    }

    public void bfs(int i,int j,char[][] grid,boolean[][] visited){
        int m =grid.length,n=grid[0].length;
        visited[i][j]=true;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] d : dir){
            int x = i+d[0] , y = j+d[1];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]=='1' && !visited[x][y] ){
                bfs(x,y,grid,visited);
            }
        }
    }
}