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
    int pathlength=0;
    private void traversal(TreeNode root , boolean goleft , int steps){
        if(root==null) return ;
        pathlength = Math.max(pathlength , steps);
        
        if(goleft){
            traversal(root.left , false , steps+1);
            traversal(root.right , true , 1);
        }
        else {
            traversal(root.left , false , 1);
            traversal(root.right , true , steps+1);
        }
      
    }

    public int longestZigZag(TreeNode root) {
        traversal(root,true,0);
        return pathlength;
    }
}