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


    private TreeNode build(int[] nums,int l,int r){
        if(l>r ) return null;

        int maxidx=l;
        for(int i=l;i<=r;i++) if(nums[i]>nums[maxidx]) maxidx=i;
        TreeNode root = new TreeNode(nums[maxidx]);
        root.left=build(nums,l,maxidx-1);
        root.right=build(nums,maxidx+1,r);

        return root;
    }



    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
}