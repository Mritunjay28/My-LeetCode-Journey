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

/*
// if match 
i < s.length() (i.e., the string still has characters left).
They match if the characters are identical, or if p[j] is .

let curr character as p[j]
// if * 
Case A: The next character is * (p[j + 1] == '*')

The pattern character p[j] cannot be evaluated in isolation because 
the character immediately following it might modify it.

Choice 1: Match 0 times (f(i, j + 2)) Ignore the whole char + * pair completely.
Example: s = "b", p = "a*b". We skip a* and match "b" with "b"

Choice 2: Match 1 (or more) times (match && f(i + 1, j)) 
We keep j where it is! Because * can match multiple characters, keeping j allows the recursive call to decide whether to consume another character from s on the next turn.

No * after p[j]
If there is no * at j + 1, this is just a strict 1-to-1 character match:
if (match) {
    return f(i + 1, j + 1, s, p);
}
return false;


*/