class Solution {
    public int maximumLengthSubstring(String s) {
        int len=0;

        int[] arr = new int[26];
        int l=0,r=0;
        while(r<s.length()){
            arr[s.charAt(r)-'a']++;

            while(arr[s.charAt(r)-'a']>2){
                arr[s.charAt(l)-'a']--;
                l++;
            }

            len=Math.max(len,r-l+1);
            r++;
        }

        return len;
    }
}