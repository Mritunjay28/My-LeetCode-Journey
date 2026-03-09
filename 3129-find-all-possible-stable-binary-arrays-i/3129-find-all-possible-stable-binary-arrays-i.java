import java.math.BigInteger;

class Solution {

    static final BigInteger MOD = BigInteger.valueOf(1000000007);

    public int numberOfStableArrays(int zero, int one, int limit) {
        BigInteger total = BigInteger.ZERO;

      
        for (int runzero = 1; runzero <= zero; runzero++) {
            for (int runone = runzero - 1; runone <= runzero + 1; runone++) {
                if (runone < 0 || runone > one) continue;

                
                int arrangements = (runzero == runone) ? 2 : 1;

                BigInteger waysZero = compositions(zero, runzero, limit);
                BigInteger waysOne  = (runone == 0)
                        ? (one == 0 ? BigInteger.ONE : BigInteger.ZERO)
                        : compositions(one, runone, limit);

                total = total.add(
                    BigInteger.valueOf(arrangements)
                        .multiply(waysZero)
                        .multiply(waysOne)
                );
            }
        }

        return total.mod(MOD).intValue();
    }

    static BigInteger compositions(int n, int r, int limit) {
        BigInteger result = BigInteger.ZERO;
        for (int j = 0; j <= r; j++) {
            int rem = n - 1 - j * limit;
            if (rem < r - 1) break;
            BigInteger term = nCr(r, j).multiply(nCr(rem, r - 1));
            if (j % 2 == 0) result = result.add(term);
            else             result = result.subtract(term);
        }
        return result;
    }

    static BigInteger nCr(int n, int r) {
        if (r < 0 || r > n) return BigInteger.ZERO;
        r = Math.min(r, n - r);
        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            res = res.multiply(BigInteger.valueOf(n - i));
            res = res.divide(BigInteger.valueOf(i + 1));
        }
        return res;
    }
}