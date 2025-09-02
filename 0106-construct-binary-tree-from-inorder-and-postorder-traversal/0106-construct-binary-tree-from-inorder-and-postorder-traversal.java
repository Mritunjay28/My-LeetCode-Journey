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
    int postidx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postidx=postorder.length-1;
        map=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(postorder , 0,postorder.length-1);
    }

    private TreeNode build( int[] postorder  , int left , int right){
        if(left>right) return null;

        int rootval= postorder[postidx--];
        int idx = map.get(rootval);
        TreeNode root = new TreeNode(rootval);

        root.right  = build(postorder ,idx+1,right );
        root.left  = build(postorder ,left, idx-1);

        return root;
    }
}