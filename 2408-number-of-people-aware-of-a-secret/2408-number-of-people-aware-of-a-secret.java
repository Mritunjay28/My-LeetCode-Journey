class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod =1000000007;
        long[] share = new long[n+1];
        if(delay < n) share[1+delay] = 1;
        long[] forgetted = new long[n+1];
        if(forget < n) forgetted[1+forget] = 1;

        long sharetoday= 0;
        long totalknown = 1;
        for(int i=delay ; i<n+1 ;i++){
            sharetoday+=share[i] %mod;
            sharetoday-=forgetted[i]%mod;

            totalknown-= forgetted[i]%mod;
            totalknown += sharetoday%mod;

            if(i+delay < n+1) share[i+delay] += sharetoday%mod;
            if(i+forget < n+1) forgetted[i+forget] += sharetoday%mod;

        }

        return (int)(totalknown%mod);
    }
}