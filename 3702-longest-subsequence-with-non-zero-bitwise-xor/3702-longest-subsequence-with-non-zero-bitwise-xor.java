class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean allzero=true;
        for(int num : nums){
            xor^=num;
            if(num!=0) allzero=false;
        } 
        if(allzero) return 0;
        if(xor==0) return nums.length-1;
        
        return nums.length;
    }
}