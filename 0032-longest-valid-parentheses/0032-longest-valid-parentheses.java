class Solution {
    public int longestValidParentheses(String s) {
       int[] dp=new int[s.length()];
    int max=0;
       for(int i=1;i<s.length();i++){
         if(s.charAt(i)==')'){
            if(s.charAt(i-1)=='(') dp[i]=((i>=2) ? dp[i-2] : 0 )+2; 
            else { 
                int matching = i - dp[i-1] -1; 
                if(matching>=0 && s.charAt(matching)=='(' ) dp[i]=dp[i-1]+(i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) +2;
            }
            max=Math.max(max,dp[i]);
         }
       }
       return max;
    }
}

  // ) ( ) ( ) )  -- if condition
//   0 0 2 0 4 0

  // ( ) ( ( ) ( ) ( ) ) - else condition
//   0 2 0 0 2 0 4 0 6 8