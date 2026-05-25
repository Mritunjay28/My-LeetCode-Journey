class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1')
            return false;

        int[] dp = new int[n + maxJump + 1];
        dp[minJump]++;
        dp[maxJump + 1]--;
        for (int i = 1; i < n; i++) {
            dp[i] += dp[i - 1];
            if (s.charAt(i) == '1')
                continue;
            if (dp[i] == 0)
                continue;

            dp[i + minJump]++;
            dp[i + maxJump + 1]--;
        }

        return dp[n - 1] > 0;
    }
}