class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev=-1;
        while(n>0){
            int rem = n%2;
            if(rem==prev) return false;
            prev=rem;
            n/=2;
        }
        return true;
    }
}