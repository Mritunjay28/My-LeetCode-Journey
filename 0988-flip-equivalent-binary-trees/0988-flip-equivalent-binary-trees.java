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

    private boolean check(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;

        boolean noswap= check(root1.left,root2.left) && check(root1.right,root2.right);
        boolean swap= check(root1.left,root2.right) && check(root1.right,root2.left);

        return swap|| noswap;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1,root2);
    }
}