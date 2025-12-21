class Solution {
    public long lastInteger(long n) {
        long first=1,last=n,skip=1;
        boolean left=true;
        while(n>1){
            if(left){
                if(n%2==0) last=last-skip;
            }
            else{
                if(n%2==0) first= first+skip;
            }
            n = (n+1)/2;
            skip=skip*2;
            left=!left;
        }
        return first;
    }
}