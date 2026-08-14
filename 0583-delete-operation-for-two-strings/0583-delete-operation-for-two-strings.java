class Solution {
    public int minDistance(String s1, String s2) {
      //  return f(0,0,s1,s2);
      int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = m; j >=0; j--) {
            dp[n][j] = m-j;
        }

        
        for (int i = n; i >=0; i--) {
            dp[i][m] = n-i;  
        }

        dp[n][m]=0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // if match then increase 
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // delete eitherr first word then take min of them 
                    int min1 = 1 + dp[i+1][j];
                    int min2 = 1 + dp[i][j+1];

                    dp[i][j] = Math.min(min1, min2);
                }
            }
        }

        return dp[0][0];
    }

    public int f(int i,int j,String s1, String s2){
        if (i == s1.length()) return s2.length()-j;
        if (j == s2.length()) return s1.length()-i;

        // if match ok move forward 
        if(s1.charAt(i)==s2.charAt(j)){
            return f(i+1,j+1,s1,s2);
        }

        int min1= 1+f(i+1,j,s1,s2);
        int min2= 1+f(i,j+1,s1,s2);

        return Math.min(min1,min2);
    }
}