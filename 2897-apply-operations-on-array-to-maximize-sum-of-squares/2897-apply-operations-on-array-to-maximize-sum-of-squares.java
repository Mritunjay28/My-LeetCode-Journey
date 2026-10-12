class Solution {
    static int mod = 1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[30];

        for(int n : nums){
            for(int i=0;i<30;i++){
                if((n & (1<<i)) !=0) count[i]++;
            }
        }

        long ans=0;
        for(int i=0;i<k;i++){
            long curr=0;
            for(int j=29;j>=0;j--){
                if(count[j]>0){
                    curr |= 1L<<j;
                    count[j]--;
                }
            }
            ans = (ans+curr*curr)%mod;
        }

        return (int) ans;
    }
}