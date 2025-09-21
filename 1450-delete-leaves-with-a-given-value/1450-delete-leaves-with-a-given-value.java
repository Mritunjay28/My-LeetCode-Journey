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

    boolean isdeleted ;
    // boolean isrootdeleted;
    private boolean dfs(TreeNode root, int target){
        if(root==null) return false;
        if(root.val==target && root.left==null && root.right==null){
            isdeleted=true;
            return true;
        }
        boolean left = dfs(root.left,target);
        boolean right = dfs(root.right,target);

        if(left) root.left=null;
        if(right) root.right=null;
        // if(root.val==target && root.left==null && root.right==null){
        //     isdeleted=true;
        //     return true;
        // }

        return false;

    }


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        isdeleted=true;
        while(isdeleted){
            isdeleted=false;
           boolean rootdeleted= dfs( root, target);
           if(rootdeleted) return null;
        }
        return root;
    }
}