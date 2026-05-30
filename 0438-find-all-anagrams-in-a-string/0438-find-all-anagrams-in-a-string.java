class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n =s.length() , m =p.length();
        int l=0,r=0;
        int[] ch = new int[26];

        for (char c : p.toCharArray()) {
            ch[c - 'a']++;
        }
        int count =m;
        List<Integer> ans = new ArrayList<>();

        while(r<n){
            if(ch[s.charAt(r)-'a']> 0 ) count--;
            ch[s.charAt(r)-'a']--;

            while(r-l+1>m){
                if(ch[s.charAt(l)-'a'] >=0 ) count++;
                ch[s.charAt(l)-'a']++;
                l++;
            }
           

            if(count==0) ans.add(l);
            r++;
        }

        return ans;
    }
}