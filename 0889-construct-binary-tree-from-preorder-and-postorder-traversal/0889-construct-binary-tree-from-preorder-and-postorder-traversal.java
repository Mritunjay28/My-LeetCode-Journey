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
    int preidx=0;
    HashMap<Integer , Integer> postmap ;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postmap=new HashMap<>();
        for(int i=0;i<postorder.length;i++) postmap.put(postorder[i],i);
        return build(preorder,postorder.length-1,0,postorder.length-1 );
    }

    private TreeNode build(int[] preorder, int n , int left , int right){
        if(left>right) return null;
        if(preidx>n) return null;

        int rootval = preorder[preidx++];
        TreeNode root = new TreeNode(rootval);

        if(left==right) return root;

        int leftrootval = preorder[preidx];
        int leftrootidx = postmap.get(leftrootval);

        root.left = build(preorder , n , left , leftrootidx);
        root.right = build(preorder , n , leftrootidx+1 , right-1);

        return root;
    }
}