class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long A = a, B = b;
        long mod = 1_000_000_007;
        
       
        long lcm = (A * B) / gcd(A, B);
       
        long l = Math.min(A, B);
        long r = (long) n * Math.min(A, B);
        long ans = r;
        
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long count = (mid / A) + (mid / B) - (mid / lcm);
            
            if (count >= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return (int) (ans % mod);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}