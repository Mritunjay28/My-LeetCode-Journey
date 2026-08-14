class Solution {
    public boolean isMatch(String s, String p) {
        // return f(0,0,s,p);
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 2][m + 2];

        dp[n][m] = true;

        for (int i = n ; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

                // If next char is '*', we branch: match 0 times (j+2) OR match 1+ times (i+1, j)
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j+2] || (match && dp[i+1][j]);
                }
                else if (match) {
                    dp[i][j] = dp[i+1][j+1];
                }
                else dp[i][j] = false;
            }
        }

        return dp[0][0];
    }

    public boolean f(int i, int j, String s, String p) {

        if (j == p.length() && i == s.length())
            return true;
        if (j == p.length())
            return false;

        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // If next char is '*', we branch: match 0 times (j+2) OR match 1+ times (i+1, j)
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return f(i, j + 2, s, p) || (match && f(i + 1, j, s, p));
        }
        if (match) {
            return f(i + 1, j + 1, s, p);
        }

        return false;
    }
}