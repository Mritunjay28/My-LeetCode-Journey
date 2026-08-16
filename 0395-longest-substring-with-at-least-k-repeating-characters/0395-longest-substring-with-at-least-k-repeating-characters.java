class Solution {
    public int longestSubstring(String s, int k) {
        if(k>s.length()) return 0;
        
        int max=0;

        for(int l=1;l<=26;l++){
            int[] freq = new int[26];
            int st=0,e=0;
            int unique=0;
            int countK=0;
            while(e<s.length()){
                if(unique<=l){
                    if(freq[s.charAt(e)-'a']==0) unique++;
                    freq[s.charAt(e)-'a']++;    
                    if(freq[s.charAt(e)-'a']==k) countK++;
                    e++;
                }
                else{
                    if(freq[s.charAt(st)-'a']==k) countK--;
                    freq[s.charAt(st)-'a']--; 
                    if(freq[s.charAt(st)-'a']==0) unique--;
                    st++;
                }
                
                if(unique==l && unique==countK) max=Math.max(max,e-st);
            }
        }

        return max;
    }
}