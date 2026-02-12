class Solution {
    public int longestBalanced(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];
            for(int j=i;j>=0;j--){
                freq[s.charAt(j)-'a']++;
                boolean allsame=true;
                Integer prev=null;
                for(int key : freq ){
                    if(key==0) continue;
                    if(prev==null) {
                        prev=key;
                    }
                    else if(prev!=key){
                        allsame=false;
                        break;
                    }
                }
                if(allsame) max=Math.max(max,i-j+1); 
            }
            
        }
        return max;
    }
}