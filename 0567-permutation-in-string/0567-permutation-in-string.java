class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n =s2.length() , m =s1.length();
        int l=0,r=0;
        int[] ch = new int[26];

        for (char c : s1.toCharArray()) {
            ch[c - 'a']++;
        }
        int count =m;

        while(r<n){
            if(ch[s2.charAt(r)-'a']> 0 ) count--;
            ch[s2.charAt(r)-'a']--;

            while(r-l+1>m){
                if(ch[s2.charAt(l)-'a'] >=0 ) count++;
                ch[s2.charAt(l)-'a']++;
                l++;
            }
           

            if(count==0) return true;
            r++;
        }

        return false;
    }
}