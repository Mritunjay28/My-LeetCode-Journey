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

    private void swap(TreeNode Left , TreeNode Right ,int level ){
        if(Left == null || Right == null) return ;

        if(level%2==1){
            int temp =Left.val;
            Left.val = Right.val;
            Right.val = temp;
        }

        swap(Left.left,Right.right,level+1);
        swap(Left.right,Right.left,level+1);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        swap(root.left,root.right,1);
        return root;
    }
}