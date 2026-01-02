class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long max = -1L;
        for(int x : coins) max=Math.max(max,x);
        long s=0,e=max*k;
        long ans= -1;
        while(s<=e){
            long mid = s+(e-s)/2;
            long count= ple(mid,coins,k);
            if(count>=k){
                ans = mid ;
                e=mid-1;
            }
            else s = mid +1;

        }
        return ans;
    }


    long ple(long n , int[] coins,int k){
        long count=0;
        for(int i=1;i<(1<<coins.length);i++){
            int setbit =0;
            long lcmval =1;
            for(int j=0;j<coins.length;j++){
                if(((i>>j) &1) == 1){
                    lcmval = lcm(lcmval,coins[j]);
                    setbit++;
                    if(lcmval>n) break;
                }
            }

            if(lcmval<=n){
                if(setbit%2==1) count+= n/lcmval;
                else count-= n/lcmval;
            }
        }

        return count;
    }

    long lcm(long a,long b){
        if(a>b){
            long t =a;
            a=b;
            b=t;
        }
        return (a*b)/gcd(a,b);
    } 

    long gcd(long a,long b){
        return (a==0)? b: gcd(b%a,a);
    }
}