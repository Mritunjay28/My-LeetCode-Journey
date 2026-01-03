class Solution {
    public int numOfWays(int n) {

       long mod = 1_000_000_007;
        
        // Base case: n = 1
        // There are 6 ABA patterns (RGR, RYR, GRG, GYG, YRY, YGY)
        // There are 6 ABC patterns (RGY, RYG, GRY, GYR, YRG, YGR)
        long aba = 6;
        long abc = 6;
        
        for (int i = 1; i < n; i++) {
            long prevAba = aba;
            long prevAbc = abc;
            
            // Apply transitions
            aba = (prevAba * 3 + prevAbc * 2) % mod;
            abc = (prevAba * 2 + prevAbc * 2) % mod;
        }
        
        return (int) ((aba + abc) % mod);
    }

    
}