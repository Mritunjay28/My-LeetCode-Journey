class Solution {
    public boolean canPartitionGrid(int[][] g) {
        int m = g.length , n =g[0].length;
        long[][] grid = new long[m][n];

 long sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum+=g[i][j];
                if(i==0 && j==0) grid[i][j] = g[i][j];
                else if (i==0) grid[i][j] = g[i][j]+ grid[i][j-1];
                else if (j==0) grid[i][j] = g[i][j] +grid[i-1][j];
                else{
                    grid[i][j] = g[i][j] + (grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1] ); 
                } 
            }
        }

       
        // horizotal
        if(n-1 >=0){
            for(int i=0;i<m-1;i++) {
            if(sum-grid[i][n-1] == grid[i][n-1]) return true;
        }
        }
        

        // vertical
        if(m-1>=0){
            for(int i=0;i<n-1;i++) {
            if(sum-grid[m-1][i] == grid[m-1][i]) return true;
        }
        }
        

        return false;
    }
}

/*

[1,4,3]
[2,3,3]


[1,5,8]
[3,10,16]

*/