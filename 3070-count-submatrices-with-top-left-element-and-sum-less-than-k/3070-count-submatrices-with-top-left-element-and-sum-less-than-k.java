class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0){
                    if(i==0){
                        if(j>0) grid[i][j]+= grid[i][j-1];
                    }
                    else{
                        if(i>0) grid[i][j]+= grid[i-1][j];
                    }
                }
                else{
                    grid[i][j]+= grid[i-1][j]+ grid[i][j-1] - grid[i-1][j-1];
                }

                if(grid[i][j] <=k) count++;
            }
        }

        return count;
    }
}

/*
[7,2,9]
[1,5,0]
[2,6,6]


[7,9,18]
[8,15,24]
[10,23,38]
*/