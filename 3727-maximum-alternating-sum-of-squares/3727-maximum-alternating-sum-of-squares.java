class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans =0;
        for(int i=0;i<nums.length;i++) if(nums[i]<0) nums[i]*=-1;
        Arrays.sort(nums);
        int n = (int)Math.ceil((double)nums.length/2);
        int e = nums.length-1;
        while(n!=0){
            ans+=Math.pow(nums[e],2);
            e--;
            n--;
        }
        for(int i=e;i>=0;i--) ans-= Math.pow(nums[i],2);

        return ans;
        
    }
}
// if odd length 1,2,3,4,5 ceil(5/2)=3
// then +1-2+3-4+5 3+ 2- =>  

// if even length then 1,2,3,4,5,6 ceil(6/2)=3
// then +1-2+3-4+5-6 3+ 3- 