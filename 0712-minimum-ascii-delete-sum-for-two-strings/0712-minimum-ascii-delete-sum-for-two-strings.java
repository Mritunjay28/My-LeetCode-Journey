class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // return f(0,0,s1,s2);
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        int sum = 0;
        for (int j = m-1; j >=0; j--) {
            sum += (int) (s2.charAt(j));
            dp[n][j] = sum;
        }

        sum = 0;
        for (int i = n-1; i >=0; i--) {
            sum += (int) (s1.charAt(i));
            dp[i][m] = sum;
        }

        dp[n][m]=0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // if match then increase 
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // delete eitherr first word then take min of them 
                    int min1 = (int) (s1.charAt(i)) + dp[i+1][j];
                    int min2 = (int) (s2.charAt(j)) + dp[i][j+1];

                    dp[i][j] = Math.min(min1, min2);
                }
            }
        }

        return dp[0][0];

    }

    public int f(int i, int j, String s1, String s2) {
        // if(i==s1.length() && j==s2.length()) return 0;
        if (i == s1.length()) {
            int sum = 0;
            for (; j < s2.length(); j++)
                sum += (int) (s2.charAt(j));
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            for (; i < s1.length(); i++)
                sum += (int) (s1.charAt(i));
            return sum;
        }

        // if match then increase 
        if (s1.charAt(i) == s2.charAt(j)) {
            return f(i + 1, j + 1, s1, s2);
        }

        // delete eitherr first word then take min of them 
        int min1 = (int) (s1.charAt(i)) + f(i + 1, j, s1, s2);
        int min2 = (int) (s2.charAt(j)) + f(i, j + 1, s1, s2);

        return Math.min(min1, min2);
    }
}