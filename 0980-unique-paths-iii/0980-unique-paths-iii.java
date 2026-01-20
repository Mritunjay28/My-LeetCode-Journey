class Solution {
    int ans=0,empty=1;// empty =1 as we consider starting block(val==1) as empty 
    int sx,sy;
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)empty++;
                if(grid[i][j]==1){
                    sx=i;
                    sy=j;
                }
            }
        }
      dfs(grid,sx,sy);
      return ans;
    }
    public void dfs(int[][] grid, int x,int y){
        if(x<0||x>=grid.length||y<0 || y>=grid[0].length||grid[x][y]<0) return ;
        if(grid[x][y]==2){
            if(empty==0) ans++; // sareh empty block travel kar liya hai toh ans++
            return;
        }
       // backtrack
        grid[x][y]=-2;
        empty--; // as first block==1 is first so consider it empty. hence empty=1 at start
        dfs(grid,x+1,y);
        dfs(grid,x,y+1);
        dfs(grid,x-1,y);
        dfs(grid,x,y-1);
        grid[x][y]=0;
        empty++;

    }
}