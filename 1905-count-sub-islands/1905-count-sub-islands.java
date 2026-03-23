class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m =grid1.length , n =grid1[0].length ;

        boolean[][] visited = new boolean[m][n];

        int k =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && grid1[i][j]==1 && !visited[i][j]){
                    boolean isallcovered = dfs(i,j,grid1,grid2,visited);
                    if(isallcovered) k++;
                }
            }
        }

        return k;
    }

    public boolean dfs(int i,int j,int[][] grid1,int[][] grid2,boolean[][] visited){
        int m =grid1.length , n =grid1[0].length ;
        visited[i][j]=true;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean ans = true;

        for(int[] d : dir){
            int x = i+d[0] , y=j+d[1];

            if(x>=0 && x<m && y>=0 && y<n ){
                if(grid2[x][y]==1 && grid1[x][y]!=1) ans = false;
                if( grid2[x][y]==1 && grid1[x][y]==1 && !visited[x][y]){
                boolean res = dfs(x,y,grid1,grid2,visited);
                ans = ans && res;
            }
            } 
        }

        return ans;
    }
}