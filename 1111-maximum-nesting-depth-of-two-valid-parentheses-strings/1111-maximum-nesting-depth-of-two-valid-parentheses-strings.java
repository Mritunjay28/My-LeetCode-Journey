class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int i=0,depth=0;
        for(int j=0;j<seq.length();j++){
            char ch = seq.charAt(j);
            if(ch=='('){
                depth++;
                ans[i++] = depth%2;
            }
            else{
                ans[i++] = depth%2;
                depth--;
            }   
        }
        return ans;
    }
}