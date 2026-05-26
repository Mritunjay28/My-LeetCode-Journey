class Solution {
    public int numberOfSpecialChars(String word) {
        int[] cap =new int[26];
        int[] small =new int[26];

        for(char ch :word.toCharArray()){
            if((ch-'A')>=0 && (ch-'A')<26 ) cap[(int)(ch-'A')]++;
            if((ch-'a')>=0 && (ch-'a')<26 ) small[(int)(ch-'a')]++;
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(cap[i]>0 && small[i]>0) count++;
        }

        return count;
    }
}