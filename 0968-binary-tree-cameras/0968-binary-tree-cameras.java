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
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==0) count++;
        return count;
    }

// 0-> need to add camera , //1->  have camera , // 2-> no camera requied  
// 0 sended to parent to request add camera 
    public int dfs(TreeNode node){

        if(node==null) return 2;

        int left = dfs(node.left);
        int right =  dfs(node.right);

        if(left==0 || right==0) {//  If any child is NOT covered, this node MUST have a camera.
            count++;
            return 1;
        }

        if(left==1 || right==1) {//  If any child HAS a camera, this node is now covered.
            return 2;
        }

       //  Otherwise (left == 2 && right == 2), children are covered 
        // but this node is currently uncovered
        return 0;
    }
}