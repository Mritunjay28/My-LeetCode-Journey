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

    HashMap<String,Integer> map = new HashMap<>();

    private String solve(TreeNode root ,List<TreeNode> ans){
        if(root==null) return "N";

        String s = root.val + "," + solve(root.left,ans) + "," + solve(root.right,ans);

        if(map.getOrDefault(s,0)==1) ans.add(root);
        map.put(s,map.getOrDefault(s,0)+1);

        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans= new ArrayList<>();
        solve(root,ans);
        return ans;
    }
}