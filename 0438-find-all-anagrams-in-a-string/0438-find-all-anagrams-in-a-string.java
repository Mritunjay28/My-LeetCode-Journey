class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n =s.length() , m =p.length();
        int l=0,r=0;
        int[] ch = new int[26];
        int[] ch2 = new int[26];

        for(int i=0;i<m;i++)  ch2[p.charAt(i)-'a']++;
        List<Integer> ans = new ArrayList<>();

        while(r<n){
            ch[s.charAt(r)-'a']++;

            while(r-l+1>m){
                ch[s.charAt(l)-'a']--;
                l++;
            }
            boolean possible = true;

            for(int i=0;i<26;i++) if(ch[i]!=ch2[i]){
                possible = false;
                break;
            }

            if(possible) ans.add(r-m+1);
            r++;
        }

        return ans;
    }
}