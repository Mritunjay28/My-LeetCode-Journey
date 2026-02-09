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
  boolean isbalance=true;
    public boolean isBalanced(TreeNode root) {
       dfs(root);
       return isbalance;
    }

    public int dfs(TreeNode root){
        if(root==null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(Math.abs(left-right)>1) isbalance=false;


        return Math.max(left,right)+1;
    }
}