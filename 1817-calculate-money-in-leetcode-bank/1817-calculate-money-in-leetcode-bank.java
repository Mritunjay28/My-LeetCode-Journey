class Solution {
    public int totalMoney(int n) {
        int sum=0,prev=1;
        while(n>0){
            int curr= prev++;
            if(n>7){
                for(int i=0;i<7;i++){
                    sum+= curr;
                    curr++;
                }
               n-=7;
            }
            else{
                for(int i=0;i<n;i++){
                    sum+=curr;
                    curr++;
                }
                n=0;
            }
        }
        return sum;
    }
}