class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n =word.length();
        int[] ans = new int[n];

        long prev =0;

        for(int i=0;i<n;i++){
            long digit = word.charAt(i)-'0';
            long num = prev*10 + digit;

            long rem = num %m;

            if(rem==0) ans[i]=1;
            else ans[i]=0;
            prev=rem;
        }

        return ans;
    }
}