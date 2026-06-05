class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int sum =0;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0) sum+=customers[i];
        }

        int ans = sum;
        int s=0,e=0;
        while(e<n){
            if(grumpy[e]==1) sum+=customers[e];

            while(e-s+1 >minutes){
                if(grumpy[s]==1) sum-=customers[s];
                s++;
            }

            ans=Math.max(ans,sum);
           
            e++;
        }

        return ans;
    }
}