class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length==1) return 0;
        int max = -1;
        for(int i=0;i<nums.length;i++){
            long maxval = (long)nums[i]*k;
            int s=i,e=nums.length-1;
            int ans=-1;
            while(s<=e){
                int mid =s+(e-s)/2;
                if(nums[mid] <= maxval){
                    ans = mid;
                    s=mid+1;
                }
                else e=mid-1;
            }
          
            max=Math.max(max,ans-i+1);
        }

        return nums.length-max;
    }
}