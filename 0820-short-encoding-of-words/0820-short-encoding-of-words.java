class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b) -> b.length()-a.length());
        int ans=0;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            if(!set.contains(s)) {
                for(int j=0;j<s.length();j++){
                    set.add(s.substring(j));
                }
                ans+=s.length();
                ans++;
            } 
        }

        return ans;
    }
}