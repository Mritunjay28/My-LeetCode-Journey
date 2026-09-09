class Solution {
    public long countCommas(long n) {
        long sum=0;
        if(n<=999L) return 0L;

        if(n>=1000) sum+= Math.min(n,999999)-999;

        if(n>=(int)1e6){
             sum+= 2*(Math.min(n,999999999)-999999);
        } 

        if(n>=1000000000){
           sum+= 3*(Math.min(n,999999999999L)-999999999);
        }

        if(n>=1000000000000L){
           sum+= 4*(Math.min(n,999999999999999L)-999999999999L);
        }

        if(n>=1000000000000000L)  sum+= 5*(n-999999999999999L);

        return sum;
    }
}