class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        long count=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
           
                while(!stack.isEmpty() && stack.peek()<nums[i]) {
                    stack.pop();
                    if(!stack.isEmpty()) count++;
                }
                 stack.push(nums[i]);
            
        }
        

        return count;
    }
}