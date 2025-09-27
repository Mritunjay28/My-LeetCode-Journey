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
    int[] levelmax = new int[100001] ;
    int[] levelsecondmax  = new int[100001];
    int[] height = new int[100001];
    int[] level = new int[100001];

    private int findheight(TreeNode root,int l){
        if(root==null) return 0;

        level[root.val]= l;
        height[root.val]= Math.max(findheight(root.left,l+1),findheight(root.right,l+1))+1;

        if(levelmax[l]<height[root.val]) {
            levelsecondmax[l]=levelmax[l];
            levelmax[l]=height[root.val];
        }else if (levelsecondmax[l]<height[root.val]){
             levelsecondmax[l]=height[root.val];
        }

        return height[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        findheight(root,0);

        int[] ans =new int[queries.length];
    
        int i=0;
        for(int n : queries){
            int l= level[n];
            int temp = l+ (levelmax[l]==height[n] ? levelsecondmax[l] : levelmax[l]) -1;
            ans[i++]=temp;
        }
        return ans;
    }
}