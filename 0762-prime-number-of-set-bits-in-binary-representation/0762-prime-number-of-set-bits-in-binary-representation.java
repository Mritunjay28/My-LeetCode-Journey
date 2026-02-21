class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){ // 10^4
           
            int count1=Integer.bitCount(i);;
           
            if(isprime(count1)) count++; // sqrt(10^6) 10^3 
        }
        // so 10^4*(20+10^3) approx 10^7 

        return count;
    }

    public boolean isprime(int x){
        if(x==1) return false;
        for(int i=2;i*i<=x;i++) if(x%i==0) return false;
        return true;
    }
}