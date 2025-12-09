class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        int ans=0;
        char[] ch = s.toCharArray();
        for(String str : map.keySet()){
            int i=0,j=0;
            while(i<str.length() && j<ch.length){
                if(str.charAt(i)==ch[j]) i++;
                j++;
            }

            if(i==str.length()) ans+= map.get(str);
        }

        return ans;
    }
}