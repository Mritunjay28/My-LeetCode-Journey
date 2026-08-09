class Solution {
    int sum=0;
    int[][] dp;
    public int countSquares(int[][] matrix) {
        sum=0;
        dp = new int[matrix.length][matrix[0].length];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        f(0,0,matrix);
        return sum;
    }

    public int f(int i,int j,int[][] matrix){
        if(i>=matrix.length || j>=matrix[0].length) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int right = f(i,j+1,matrix);
        int down = f(i+1,j,matrix);
        int downRight = f(i+1,j+1,matrix);

        if(matrix[i][j]==0) return dp[i][j]=0;
        
        int min = Math.min(right,Math.min(down,downRight));
        sum+=min+1;
        return dp[i][j]=min+1;
    }
}