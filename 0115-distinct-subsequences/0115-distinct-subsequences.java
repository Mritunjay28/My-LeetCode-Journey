class Solution {
    public int numDistinct(String s, String t) {
        //  return f(0,0,s,t);
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++)
            dp[i][m] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int count = 0;
                // take if equal 
                if (s.charAt(i) == t.charAt(j)) {
                    count += dp[i + 1][j + 1];
                }

                count += dp[i + 1][j];

                dp[i][j] = count;
            }
        }

        return dp[0][0];
    }

    public int f(int i, int j, String s, String t) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        int count = 0;
        // take if equal 
        if (s.charAt(i) == t.charAt(j)) {
            count += f(i + 1, j + 1, s, t);
        }

        count += f(i + 1, j, s, t);

        return count;
    }
}