class Solution {
    public String reorganizeString(String s) {
        // check if string formation is possible or not
        int[] count = new int[26];
        int max=-1,maxidx=-1;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            if(count[s.charAt(i)-'a'] >max){
                max=count[s.charAt(i)-'a'];
                maxidx=s.charAt(i)-'a';
            }
        }

        if(max>(s.length()+1)/2 ) return "";

        char[] arr = new char[s.length()];
        int idx=0;
        while(count[maxidx]-- >0){
            arr[idx] = (char)(maxidx+'a');
            idx+=2;
        }

        for(int i=0;i<26;i++){
           
            while(count[i]-- >0){
                if(idx>=arr.length) idx=1;
                arr[idx] = (char)(i+'a');
                idx+=2;
            }
        }
        return String.valueOf(arr);
    }
}