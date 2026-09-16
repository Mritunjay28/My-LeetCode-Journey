class Solution {
    private static final int MOD = 1_000_000_007;
    private Long[][][][] memo;
    public int countSteppingNumbers(String low, String high) {
        long countHigh = countValid(high);
        long countLow = countValid(low);

        long ans = (countHigh - countLow + MOD) % MOD;
        if (isStepping(low)) {
            ans = (ans + 1) % MOD;
        }

        return (int) ans;
    }

    private long countValid(String s) {
        int n = s.length();
        // memo[idx][tight (0 or 1)][leadingZero (0 or 1)][prevDigit (0 to 10)]
        // 10 represents "no previous digit placed yet"
        memo = new Long[n][2][2][11];
        return dp(0, true, true, 10, s);
    }

    private long dp(int idx, boolean tight, boolean leadingZero, int prevDigit, String s) {
        if (idx == s.length()) {
            // leadingZero == true means the number formed is empty (all zeros)
            return leadingZero ? 0 : 1;
        }

        int t = tight ? 1 : 0;
        int lz = leadingZero ? 1 : 0;
        if (memo[idx][t][lz][prevDigit] != null) {
            return memo[idx][t][lz][prevDigit];
        }

        int limit = tight ? (s.charAt(idx) - '0') : 9;
        long ways = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);

            if (leadingZero) {
                if (d == 0) {
                    // Still leading zero, prevDigit remains unset (10)
                    ways = (ways + dp(idx + 1, nextTight, true, 10, s)) % MOD;
                } else {
                    // First non-zero digit placed
                    ways = (ways + dp(idx + 1, nextTight, false, d, s)) % MOD;
                }
            } else {
                // Must be adjacent: |d - prevDigit| == 1
                if (Math.abs(d - prevDigit) == 1) {
                    ways = (ways + dp(idx + 1, nextTight, false, d, s)) % MOD;
                }
            }
        }

        return memo[idx][t][lz][prevDigit] = ways;
    }

    private boolean isStepping(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != 1) {
                return false;
            }
        }
        return true;
    }
}
/*
as string of lengthh is 100 so int value is 10^100
we cannot try to runn a loop form low to high 

so how tosolve for small low to high  ??

if(s.length()==1) then all stepping 
so stepping number is formed when digit are adjacent to are actually adjacent of digit 
like for 0 -1
1-0,2
2-1,3
3-4,2
4-3,5
...
9-8

so when number is is one length all ok 
when 2 then only if ajacent number _ _  we can have 
so 0 cannot be first char and the adjacent cannot be same as prev

so for 1st pos we have we have 9 way but 8-2 . 1-1 so 16+1 = 17

for 3 digit 
it 8- it complex ..............



any other way ??
can we do recursion ?? NOPE 

their is a way digit dp 

in this we will do count = f(R) - f(L-1);
but f(l-1) is complex so we do ans = f(high) - f(low) + (isStepping(low)  ?  1 : 0)

If tight == true: your current choice is capped at S[idx] - '0'.
If tight == false: your current choice is freely 0 through 9.
For the next slot: you remain tight only if you were already tight AND you chose the maximum possible digit (digit == limit).

If you are placing 0 while leadingZero is still true, you are just padding. Do not count it toward your state.As soon as you place any digit $> 0$, the real number has started, and leadingZero becomes false for all future digits.
*/