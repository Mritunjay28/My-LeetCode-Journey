class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // return solve(0, 0, s1, s2, s3);

        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;

        for (int i = n ; i >= 0; i--) {
            for (int j = m ; j >= 0; j--) {
                if(i==n && j==m) continue;
                int k = i + j;
                boolean choice1 = false;
                boolean choice2 = false;

                if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                    choice1 = dp[i+1][j];
                }

                if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
                    choice2 = dp[i][j+1]; 
                }

                dp[i][j]= choice1 || choice2;
            }
        }

        return dp[0][0];
    }

    private boolean solve(int i, int j, String s1, String s2, String s3) {

        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        int k = i + j;
        boolean choice1 = false;
        boolean choice2 = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            choice1 = solve(i + 1, j, s1, s2, s3);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            choice2 = solve(i, j + 1, s1, s2, s3);
        }

        return choice1 || choice2;
    }
}