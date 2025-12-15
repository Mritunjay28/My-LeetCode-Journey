class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            if(stack.isEmpty()) stack.push(prices[i]);
            else{
                if(prices[i] >= stack.peek()) stack.clear();
                else{
                    int diff  = stack.peek() - prices[i];
                    if(diff!=1)stack.clear();
                }
                stack.push(prices[i]);
            }
            ans+= stack.size();
        }

        return ans;
    }
}