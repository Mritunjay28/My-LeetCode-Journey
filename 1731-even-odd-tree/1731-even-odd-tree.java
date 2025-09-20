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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int len=q.size();
            int prev=1000001;
            if(level%2==0) {
                prev=-1;
            }
           
            for(int i=0;i<len;i++){
                TreeNode curr =q.poll();
                if(level%2==0){
                    if(curr.val%2==0 || curr.val <= prev) return false;
                }
                else{
                    if(curr.val%2!=0 || curr.val >= prev) return false;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                prev=curr.val;
            }

            level++;
        }

        return true;
    }
}