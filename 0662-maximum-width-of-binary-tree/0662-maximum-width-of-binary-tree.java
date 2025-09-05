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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qidx = new LinkedList<>();
        q.add(root);
        qidx.add(1);
        int max=0;
        while(!q.isEmpty()){
            int l = q.size();
            int start=0,end=0;
            for(int i=0;i<l;i++){
                TreeNode curr = q.poll();
                int index = qidx.poll();
                if(i==0) start=index;
                if(i==l-1) end=index;
                if(curr.left!=null) {
                    q.add(curr.left);
                    qidx.add(index*2);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                    qidx.add(index*2+1);
                }

            }
            max= Math.max(max,end-start+1);
        }

        return max;

    }
}

// method to give numbering if root no is 0 then root left index is 2*rootindex+1 and right index is 2*rootindex+2 

// if root no is 1 then root left index is 2*rootindex and root left index is 2*rootindex+1  