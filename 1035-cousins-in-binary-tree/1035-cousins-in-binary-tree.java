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
    int xlevel,ylevel,xparent,yparent;
    private void dfs(TreeNode root, int x, int y, int level){
        if(root==null) return ;

        if(root.left!=null && root.left.val==x){
            xlevel=level+1;
            xparent=root.val;
        }
        if(root.left!=null && root.left.val==y){
            ylevel=level+1;
            yparent=root.val;
        }
        if(root.right!=null && root.right.val==x){
            xlevel=level+1;
            xparent=root.val;
        }
        if(root.right!=null && root.right.val==y){
            ylevel=level+1;
            yparent=root.val;
        }

        dfs(root.left,x,y,level+1);
        dfs(root.right,x,y,level+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0);
        if(xlevel==ylevel && xparent!=yparent) return true;
        return false;
    }
}