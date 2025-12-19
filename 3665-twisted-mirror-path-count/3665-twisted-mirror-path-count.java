class Solution {
    int mod = 1000000007;
    int[][][] memo;
    public int uniquePaths(int[][] grid) {
        memo =new int[grid.length][grid[0].length][2];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                Arrays.fill(memo[i][j],-1);
            }
        } 
        return recursion(grid,0,0,0)%mod;
    }

    public int recursion(int[][] grid,int dir,int i,int j){
        
        
        if(i>=grid.length || j>=grid[0].length) return 0;
        if(i==grid.length-1 && j==grid[0].length-1) return 1;

        if(memo[i][j][dir] !=-1) return memo[i][j][dir];

        long ways=0;

        if(grid[i][j]==0){
            ways += recursion(grid,0,i+1,j);
            ways += recursion(grid,1,i,j+1);
        }
        else{
            if(dir==0) ways+=recursion(grid,1,i,j+1);
            else ways+=recursion(grid,0,i+1,j);
        }
        return memo[i][j][dir] = (int)(ways%mod);
    }
}