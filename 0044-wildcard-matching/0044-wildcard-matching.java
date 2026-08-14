class Solution {
    public boolean isMatch(String s, String p) {
        // return f(s.length() - 1, p.length() - 1, s, p);
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        // Base case: empty string matched with pattern containing only '*'
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char charP = p.charAt(j - 1);
                char charS = s.charAt(i - 1);

                if (charP == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if (charP == '?' || charP == charS) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = false;
            }
        }

        return dp[n][m];
    }

    public boolean f(int i, int j, String s, String p) {
        if (i < 0 && j < 0)
            return true;
        if (j < 0)
            return false;
        if (i < 0) {
            // String exhausted: valid ONLY if all remaining characters in p[0...j] are '*'
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (p.charAt(j) == '*') {
            return f(i, j - 1, s, p) || f(i - 1, j, s, p);
        }
        if (p.charAt(j) == '?')
            return f(i - 1, j - 1, s, p);

        if (s.charAt(i) == p.charAt(j))
            return f(i - 1, j - 1, s, p);
        return false;
    }
}