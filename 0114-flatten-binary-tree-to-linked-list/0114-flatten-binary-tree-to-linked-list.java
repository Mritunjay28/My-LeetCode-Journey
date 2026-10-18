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
    public void flatten(TreeNode root) {
        f(root);
    }

    public TreeNode f(TreeNode node){
        if(node == null) return null;

        TreeNode left = f(node.left);
        TreeNode right = f(node.right);

        if(left==null && right==null) return node;
        if(left==null) return node;

        node.right=left;
        node.left=null;
        if(right==null) return node;
        while(left.right!=null) left=left.right;
        left.right=right;
        return node;
          
    }
}