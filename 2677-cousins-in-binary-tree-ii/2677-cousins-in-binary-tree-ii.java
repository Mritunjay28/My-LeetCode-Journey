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
    
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int levelsum=root.val;

        while(!q.isEmpty()){
            int nextlevelsum=0;
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode curr = q.poll();
                curr.val= levelsum-curr.val;
                int siblingsum=0;
                if(curr.left!=null) siblingsum+=curr.left.val;
                if(curr.right!=null) siblingsum+=curr.right.val;

                if(curr.left!=null){
                    nextlevelsum+=curr.left.val;
                    curr.left.val=siblingsum;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    nextlevelsum+=curr.right.val;
                    curr.right.val=siblingsum;
                    q.add(curr.right);
                }

            }
            levelsum=nextlevelsum;

        }
        return root;
    }
}