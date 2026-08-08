class Solution {
    public int uniquePaths(int m, int n) {
      //  return f(0,0,m,n);
      int[][] dp = new int[m+1][n+1];

      dp[m-1][n-1]=1;

      for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            dp[i][j] += dp[i+1][j] + dp[i][j+1];
        }
      }

      return dp[0][0];
    }

    // public int f(int i,int j,int m,int n){
    //     if(i>m-1 || j>n-1) return 0;
    //     if(i==m-1 && j==n-1) return 1;

    //     int count=0;
    //     count+=f(i+1,j,m,n);
    //     count+=f(i,j+1,m,n);

    //     return count;
    // }
}