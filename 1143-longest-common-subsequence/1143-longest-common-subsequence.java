class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return f(0,0,text1,text2);
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int common = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    common = 1 + dp[i+1][j+1];
                }

                int skip1 = dp[i][j+1];
                int skip2 = dp[i+1][j];

                dp[i][j] = Math.max(common, Math.max(skip1, skip2));
            }
        }

        return dp[0][0];
    }

    // public int f(int i,int j,String text1, String text2){
    //     if(i>=text1.length() || j>=text2.length()) return 0;

    // int common =0;
    // if(text1.charAt(i)==text2.charAt(j)) {
    //     common  = 1+f(i+1,j+1,text1,text2);
    // }

    // int skip1 =  f(i,j+1,text1,text2);
    // int skip2 =  f(i+1,j,text1,text2);

    // return Math.max(common,Math.max(skip1,skip2));
    // }
}