class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder sb  =new StringBuilder();
        for(int i=0;i<words.length;i++){
            int count =0;
            String s = words[i];
            for(int j=0;j<s.length();j++) count+= weights[s.charAt(j)-'a'];

            count%=26;
            count=25-count;
            sb.append((char)('a'+count));
        }

        return sb.toString();
    }
}