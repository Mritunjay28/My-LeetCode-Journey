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
    int count=0;

    private int travel(TreeNode root){
        if(root==null) return 0;

        int left = travel(root.left);
        int right = travel(root.right);

        int sum= left+right+(root.val-1);
        count+=Math.abs(sum);
        return sum;
    }

    public int distributeCoins(TreeNode root) {
        travel(root);
        return count;
    }
}