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
    int preidx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder , Integer.MIN_VALUE ,Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder , int left ,int right){
        if(preidx>preorder.length-1) return null;

        int rootval= preorder[preidx];

        if(rootval<left || rootval>right) return null;
        preidx++;

        TreeNode root = new TreeNode(rootval);

        root.left = build(preorder , left , rootval);
        root.right = build(preorder , rootval,right);

        return root;
    }
}