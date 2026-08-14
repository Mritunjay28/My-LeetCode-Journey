class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        // return f(0,0,s1,s2);
        int n = s1.length();
        int m = s2.length();

    //    String[][] dp = new String[n + 1][m + 1]; 
    // MLE AS String[1000][1000] appox 10^6 * 40--100 bytes which approx 100--200 MB while cause mle 
    // Store only lengths in a 2D integer array: int[][] dp
    //.Trace the table pointers from (0, 0) down to (n, m) once to build the final answer using a single StringBuilder.

        // for (int i = 0; i <= m; i++)
        //     dp[n][i] = s2.substring(i);
        // for (int i = 0; i <= n; i++)
        //     dp[i][m] = s1.substring(i);

        // for (int i = n - 1; i >= 0; i--) {
        //     for (int j = m - 1; j >= 0; j--) {
        //         if (s1.charAt(i) == s2.charAt(j)) {
        //             dp[i][j] = s1.charAt(i) + dp[i+1][j+1];
        //         } else {
        //             String choice1 = s1.charAt(i) + dp[i+1][j];
        //             String choice2 = s2.charAt(j) + dp[i][j+1];

        //             dp[i][j] = choice1.length() < choice2.length() ? choice1 : choice2;
        //         }
        //     }
        // }

        // return dp[0][0];


        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][m] = n - i;
        }
        for (int j = 0; j <= m; j++) {
            dp[n][j] = m - j;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] <= dp[i][j + 1]) {
                sb.append(s1.charAt(i));
                i++;
            } else {
                sb.append(s2.charAt(j));
                j++;
            }
        }

        while (i < n) sb.append(s1.charAt(i++));
        
        while (j < m) sb.append(s2.charAt(j++));
        
        return sb.toString();
    }

    public String f(int i, int j, String s1, String s2) {

        if (i == s1.length())
            return s2.substring(j);
        if (j == s2.length())
            return s1.substring(i);

        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + f(i + 1, j + 1, s1, s2);
        }

        String choice1 = s1.charAt(i) + f(i + 1, j, s1, s2);
        String choice2 = s2.charAt(j) + f(i, j + 1, s1, s2);

        return choice1.length() < choice2.length() ? choice1 : choice2;
    }
}