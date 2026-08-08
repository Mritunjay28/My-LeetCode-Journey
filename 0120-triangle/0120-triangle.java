class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      //  return f(0,0,triangle);
      int n = triangle.size();
      int m = triangle.get(n-1).size();

      int[][] dp = new int[n][m];

      for(int i=0;i<m;i++) dp[n-1][i] = triangle.get(n-1).get(i);

       for(int i=n-2;i>=0;i--){
        for(int j=0;j<triangle.get(i).size();j++){
            int down = dp[i+1][j];
            int downRight = dp[i+1][j+1]; 

           dp[i][j] =  triangle.get(i).get(j) + Math.min(down,downRight);
        }
       }

       return dp[0][0];

    }

    // public int f(int i,int j,List<List<Integer>> triangle){
    //     if(i==triangle.size()-1) return triangle.get(i).get(j);

    //     int down = f(i+1,j,triangle);
    //     int downRight = f(i+1,j+1,triangle);

    //     return triangle.get(i).get(j) + Math.min(down,downRight);
    // }
}