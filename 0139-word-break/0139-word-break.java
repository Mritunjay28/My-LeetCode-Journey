class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // return f(0, s, wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for (int l = n - 1; l >= 0; l--) {
            boolean ans = false;

            for (int k = 0; k < wordDict.size(); k++) {
                boolean match = true;
                String curr = wordDict.get(k);
                if (s.length() - l >= curr.length() && s.charAt(l) == curr.charAt(0)) {
                    for (int i = l, j = 0; i < s.length() && j < curr.length(); i++, j++) {
                        if (s.charAt(i) != curr.charAt(j)) {
                            match = false;
                            break;
                        }
                    }
                } else
                    match = false;

                if (match){
                    ans |= dp[l+curr.length()];
                }
                    
            }

            dp[l] =  ans;
        }

        return dp[0];

    }

    public boolean f(int x, String s, List<String> wordDict) {
        if (x == s.length())
            return true;

        boolean ans = false;

        for (int k = 0; k < wordDict.size(); k++) {
            boolean match = true;
            String curr = wordDict.get(k);
            if (s.length() - x >= curr.length() && s.charAt(x) == curr.charAt(0)) {
                for (int i = x, j = 0; i < s.length() && j < curr.length(); i++, j++) {
                    if (s.charAt(i) != curr.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            } else
                match = false;

            if (match)
                ans |= f(x + curr.length(), s, wordDict);
        }

        return ans;
    }
}