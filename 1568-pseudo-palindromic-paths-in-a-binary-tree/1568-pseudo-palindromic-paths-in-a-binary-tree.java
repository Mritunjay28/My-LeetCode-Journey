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

    int count = 0;
    HashMap<Integer, Integer> map = new HashMap();

    private void travel(TreeNode root) {
        if (root == null)
            return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        if (root.left == null && root.right == null) {
            int countodd = 0;
            for (Integer key : map.keySet()) {
                if(map.get(key)%2!=0) countodd++;
                if(countodd>1) break;
            }
            if(countodd<=1) count++;
        }
        else {
             travel(root.left);
             travel(root.right);
        }

        map.put(root.val,map.get(root.val) - 1);
        if(map.get(root.val)==0) map.remove(root.val);
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        travel(root);

        return count;
    }
}