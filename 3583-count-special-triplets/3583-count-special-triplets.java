class Solution {
    public int specialTriplets(int[] nums) {
        int[] right = new int[100001];
        for(int i=0;i<nums.length;i++) right[nums[i]]++;

        long ans=0;
        int mod= 1000000007;

        int[] left = new int[100001];
        for(int i=0;i<nums.length;i++){
            right[nums[i]]--;
            int target = nums[i]*2;
            if(target <100001) ans= (ans+1L * left[target]*right[target])%mod;
            left[nums[i]]++;
        }
        return (int)ans;
    }
}