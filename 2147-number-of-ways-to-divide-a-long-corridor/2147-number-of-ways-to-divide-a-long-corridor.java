class Solution {
    public int numberOfWays(String c) {
        int count=0;
        for(int i=0;i<c.length();i++){
            if(c.charAt(i)=='S') count++;
        }
        if(count==0 || count%2!=0) return 0;
        if(count==2) return 1;

        long ans=1;
        long mod = 1000000007;
        count=0;
        int n=0; // count = no of sin the segment , n=no of permissiable segment with 2 s
        for(int i=0;i<c.length();i++){
            if(c.charAt(i)=='S') count++;
            if(count==2) n++;
            if(count>2){
                ans= (ans*n)%mod;
                count=1;
                n=0;
            }
        }

        // if(n>0)  ans= (ans*n)%mod;
        return (int)ans;
    }
}