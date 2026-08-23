class Solution {
    public int minCut(String s) {
        if (isPalindrome(s)) return 0;

        // return f(0,0,s);

        int n = s.length();

        boolean[][] isPal = new boolean[n+1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++) dp[n][i] = (int) 1e9;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // String prev = s.substring(j, i + 1);
                // String next = s.substring(i + 1, s.length());

                boolean isprev = isPal[j][i];
                boolean isnext = isPal[i+1][n-1];

                if (isprev && isnext)
                    dp[i][j] = 1;
                else {
                    int min = (int) 1e9;
                    if (isprev) min = Math.min(min, 1 + dp[i + 1][i + 1]);
                    min = Math.min(min, dp[i + 1][j]);
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][0];
    }

    public int f(int i, int l, String s) {

        String prev = s.substring(l, i + 1);
        String next = s.substring(i + 1, s.length());

        boolean isprev = isPalindrome(prev);
        boolean isnext = isPalindrome(next);

        if (isprev && isnext)
            return 1;
        int min = (int) 1e9;
        if (isprev)
            min = Math.min(min, 1 + f(i + 1, i + 1, s));
        min = Math.min(min, f(i + 1, l, s));
        return min;
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}