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

    long max=0;

    private long dfs(TreeNode root , long total){
        if(root==null) return 0;

        long leftsum = dfs(root.left , total);
        long rightsum = dfs(root.right , total);

        long sum =root.val+leftsum+rightsum ;

        max=Math.max(max,sum*(total-sum));

        return sum;
    }



    public int maxProduct(TreeNode root) {
        long totalsum=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr= q.poll();
              if(curr!=null) {
                totalsum+=curr.val;
                q.add(curr.left);
                q.add(curr.right);
              } 
        }
        
        dfs(root,totalsum);
        return (int)(max % 1_000_000_007);
    }
}