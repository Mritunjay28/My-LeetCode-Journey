class Solution {
    public int longestBalanced(int[] nums) {
        int ans=0;
       
        for(int s=0;s<nums.length;s++){
           int e=s;
             HashSet<Integer> even = new HashSet<>();
             HashSet<Integer> odd = new HashSet<>();
            while(e<nums.length){
            if(nums[e]%2==0 ) even.add(nums[e]);
            else odd.add(nums[e]);

            if(even.size()==odd.size()) ans=Math.max(ans,e-s+1);

            e++;
        }
        }
        return ans;
        
    }
}