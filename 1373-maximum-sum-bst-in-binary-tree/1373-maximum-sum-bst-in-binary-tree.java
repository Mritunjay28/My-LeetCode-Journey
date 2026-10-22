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
    int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public long[] dfs(TreeNode node) {
        // {isBST, min, max, sum}
        if (node == null)
            return new long[] { 1, Long.MAX_VALUE, Long.MIN_VALUE, 0 };

        long[] left = dfs(node.left);
        long[] right = dfs(node.right);

        if (left[0] == 1 && right[0] == 1 && left[2] < node.val && node.val < right[1]) {

            long sum = left[3] + right[3] + node.val;
            ans = (int) Math.max(ans, sum);

            return new long[] {1,Math.min(left[1], node.val),Math.max(right[2], node.val),sum};
        }

        return new long[] { 0, 0, 0, 0 };
    }
}