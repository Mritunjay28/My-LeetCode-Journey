class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,product=1;
        int x=n;
        while(n>0){
            sum+=n%10;
            product*=n%10;
            n/=10;
        }

        if(x%(sum+product)==0) return true;
        return false;
    }
}