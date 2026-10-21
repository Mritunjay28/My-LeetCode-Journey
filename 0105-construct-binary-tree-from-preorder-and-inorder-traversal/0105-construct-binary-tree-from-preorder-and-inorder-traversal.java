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

    int i=0;
    HashMap<Integer, Integer> map = new HashMap<>();

    private TreeNode solve(int[] preorder, int[] inorder,int l , int r){
        if(l>r) return null;

        int rootval = preorder[i++];
        // int j=0;
        // for(;j<inorder.length;j++)  if(inorder[j]==rootval) break;

        TreeNode root = new TreeNode(rootval);

        root.left= solve(preorder , inorder , l , map.get(rootval)-1);
        root.right= solve(preorder , inorder , map.get(rootval)+1 , r);

        return root;
    
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); 
        }
        return solve(preorder , inorder , 0 , inorder.length-1);
    }
}