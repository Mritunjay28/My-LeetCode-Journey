class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return target;
                }
                else if(sum>target){
                    if(Math.abs(sum-target)<Math.abs(ans-target)){
                        ans=sum;
                    }
                    k--;
                }
                else{
                    if(Math.abs(sum-target)<Math.abs(ans-target)){
                        ans=sum;
                    } 
                    j++;
                }
            }   
        }
          return ans;
    }
}