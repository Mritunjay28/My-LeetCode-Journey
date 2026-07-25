class Solution {
    public int maxProduct(int n) {
        int max=-1;
        int secondmax=-1;
        while(n>0){
            int rem = n%10;
            if(rem>max){
                secondmax=max;
                max=rem;
            }
            else if(rem>secondmax) secondmax=rem;

            n/=10;
        }

        return max*secondmax;
    }
}