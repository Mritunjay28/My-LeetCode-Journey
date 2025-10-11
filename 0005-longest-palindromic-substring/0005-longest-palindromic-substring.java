
        class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";

        int n=s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        int max=0,endindex=0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)) {
                    dp[i][j]= 1+ dp[i-1][j-1] ;
                }
                    // original index = i - 1
                    // reversed index = j - 1
                    // actual index in original string from reversed = n - j

                if ((i - dp[i][j]) == (n - j)) { // validate position match
                   if (dp[i][j] > max) {
                     max = dp[i][j];
                     endindex = i - 1; // last index of palindrome in original string
                   }
                }
            }
        }

        int stindex= endindex-max +1;

        return s.substring(stindex,endindex+1);
       
    }
}
    