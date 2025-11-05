class Solution {
    public int longestSubarray(int[] nums) {
        int s=0,e=2;
        int prev=nums[0],curr=nums[1];
        int ans=2;
        boolean isfibonacchi = false;
        while(e<nums.length){
            if(nums[e]==prev+curr) isfibonacchi=true;
            else{
                isfibonacchi=false;
                s=e-1;
            } 
            prev=curr;
            curr=nums[e];
            
            if(isfibonacchi) ans=Math.max(ans,e-s+1);
            e++;            
        }
        return ans;
    }
}