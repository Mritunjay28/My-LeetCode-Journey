/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    String ans="";
    private void dfs(TreeNode root,StringBuilder sb){
        if(root==null) return ;
        sb.append((char)(root.val+'a'));

        if(root.left==null && root.right==null){
            if(ans.isEmpty()){
                ans = new StringBuilder(sb).reverse().toString();
            }
            else {
                String comb = new StringBuilder(sb).reverse().toString();
                if(ans.compareTo(comb) >0) ans=comb;
            }
        }
        else{
            dfs(root.left,sb);
            dfs(root.right,sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }

    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return ans;
    }
}