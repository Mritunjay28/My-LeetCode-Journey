class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        recursion(ans,sb,1,0,n);
        return ans;
    }

    public void recursion(List<String> ans,StringBuilder sb,int left,int right,int n){
        if(left==n && right==n) {
            ans.add(sb.toString());
            return;
        }

        if(left<n){
            sb.append('(');
            recursion(ans,sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(left>right && right<n){
            sb.append(')');
            recursion(ans,sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}