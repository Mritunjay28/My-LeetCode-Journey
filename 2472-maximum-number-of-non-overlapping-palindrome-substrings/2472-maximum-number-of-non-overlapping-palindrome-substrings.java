class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n+1];
        int max=0;
        int prev=0;
        boolean[][] palindrome = new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i <=1 || palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=n-1;j>=i;j--){
                if(j-i+1 < k) break;
                if(palindrome[i][j]){
                   max=Math.max(max,1+dp[i]);
                    dp[j+1]=Math.max(dp[j+1],dp[i]+1);
                }
                dp[i+1]=Math.max(dp[i+1],dp[i]);
            }
        }

        return max;
    }

    // public boolean isPalindrome(String s , int i,int j){
    //     while(i<j){
    //         if(s.charAt(i)!=s.charAt(j)) return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}
/*
for eacch index store no of palindrome possible previous to that index is dp[i];
then check for each pair possible from current index then add that prev by this no overlap .

will it be correct ?? => thinking so 

a b a c c d b b d n
0 0 0 1 0 0 0 0 0 2


*/