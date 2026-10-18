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
    List<TreeNode> arr = new ArrayList<>();

    private TreeNode solve(TreeNode root, HashSet<Integer> map){
        if(root==null) return null;

          root.left=solve(root.left,map);
        root.right=solve(root.right,map);
        if(map.contains(root.val)){
            if(root.left!=null) arr.add(root.left);
            if(root.right!=null) arr.add(root.right);
            return null;
        }
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
       HashSet<Integer> map = new HashSet<>();
        for(int i : to_delete) map.add(i);
        if(solve(root,map)!=null) arr.add(root);
        return arr;
    }
}