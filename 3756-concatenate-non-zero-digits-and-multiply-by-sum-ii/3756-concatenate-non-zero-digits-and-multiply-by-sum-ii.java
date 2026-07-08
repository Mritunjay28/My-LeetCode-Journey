class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int mod = 1_000_000_007;

        long[] power10 = new long[n + 1];
        power10[0] = 1;
        for (int i = 1; i <= n; ++i) 
            power10[i] = (power10[i - 1] * 10) % mod;

        long[] prefixValue = new long[n + 1];
        long[] prefixDigitSum = new long[n + 1];
        int[] prefixCount = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            int digit = s.charAt(i) - '0';
            if (digit > 0) {
                prefixValue[i + 1] = (prefixValue[i] * 10 + digit) % mod;
                prefixCount[i + 1] = prefixCount[i] + 1;
                prefixDigitSum[i + 1] = prefixDigitSum[i] + digit;
            } else {
                prefixValue[i + 1] = prefixValue[i];
                prefixCount[i + 1] = prefixCount[i];
                prefixDigitSum[i + 1] = prefixDigitSum[i];
            }
        }

        int[] result = new int[queries.length];
        int idx = 0;

        for (int[] q : queries) {
            int l = q[0], r = q[1];

            long sumDigits = prefixDigitSum[r + 1] - prefixDigitSum[l];
            int count = prefixCount[r + 1] - prefixCount[l];

            long rightVal = prefixValue[r + 1];
            long leftVal = prefixValue[l];
            long shiftedLeft = (leftVal * power10[count]) % mod;

            long x = (rightVal - shiftedLeft + mod) % mod;
            result[idx++] = (int) ((x * sumDigits) % mod);
        }

        return result;
    }
}