class Solution {
    public int longestPalindromeSubseq(String s) {
        // return f(0,s.length()-1,s);
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) dp[i][i] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) { 
                if (s.charAt(i) == s.charAt(j)) {
                   dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    int count1 = dp[i + 1][j];
                    int count2 = dp[i][j - 1];
                    dp[i][j] = Math.max(count1, count2);
                }
            }
        }

        return dp[0][n - 1];
    }

    public int f(int i,int j,String s){
        if(i==j) return 1;
        if(j<i) return 0;

    if(s.charAt(i)==s.charAt(j)) {
        int count = 2+f(i+1,j-1,s);
        return count;
    }
    else {
        int count1 = f(i+1,j,s);
        int count2 = f(i,j-1,s);
        return Math.max(count1,count2);
    }
    }
}