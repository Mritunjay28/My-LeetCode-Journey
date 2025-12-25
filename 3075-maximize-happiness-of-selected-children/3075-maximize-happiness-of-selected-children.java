class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n =0;
        long ans=0;
        for(int i=happiness.length-1;i>=0;i--){
            if(happiness[i]-n<=0 || k<=0) break;
            ans+=(long)(happiness[i]-n);
            n++;
            k--;
        }

        return ans;
    }
}