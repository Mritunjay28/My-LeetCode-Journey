class Solution {
    public int minOperations(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int i=-1;
        for( i=nums.length-1;i>=0;i-- ){
            if(seen.contains(nums[i])) {
                break;
            }
            seen.add(nums[i]);
        }
        if(i==-1) return 0;
        return (int)Math.floor((double)i/3)+1;
    }
}