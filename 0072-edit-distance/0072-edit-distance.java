class Solution {
    public int minDistance(String word1, String word2) {
        //  return f(0,0,word1,word2);
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++)
            dp[n][i] = m -i;
        for (int i = 0; i < n + 1; i++)
            dp[i][m] = n - i ;

        dp[n][m] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j]= dp[i+1][j+1];
                } else {
                    // insert a character 
                    int val1 = 1 + dp[i][j+1];
                    // delete a character 
                    int val2 = 1 + dp[i+1][j];
                    // replace a character
                    int val3 = 1 + dp[i+1][j+1];

                    dp[i][j] = Math.min(val1, Math.min(val2, val3));
                }
            }
        }

        return dp[0][0];
    }

    public int f(int i, int j, String word1, String word2) {
        if (i == word1.length() && j == word2.length())
            return 0;
        if (i == word1.length())
            return word2.length() - j;
        if (j == word2.length())
            return word1.length() - i;

        // match 
        if (word1.charAt(i) == word2.charAt(j)) {
            return f(i + 1, j + 1, word1, word2);
        }

        // insert a character 
        int val1 = 1 + f(i, j + 1, word1, word2);
        // delete a character 
        int val2 = 1 + f(i + 1, j, word1, word2);
        // replace a character
        int val3 = 1 + f(i + 1, j + 1, word1, word2);

        return Math.min(val1, Math.min(val2, val3));
    }
}

/*
abcd  abcde
0123  01234
i=4   j=4
*/