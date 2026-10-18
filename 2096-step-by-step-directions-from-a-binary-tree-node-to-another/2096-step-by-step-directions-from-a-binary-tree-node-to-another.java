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
    HashMap<TreeNode , TreeNode> parentmap;
    TreeNode startnode;
    TreeNode endnode;
    int n=0;

    private void makeparentmap(TreeNode root,HashMap<TreeNode , TreeNode> parentmap, int startValue, int destValue){
        if(root==null) return ;

        if(root.val==startValue ) startnode= root;
        if(root.val==destValue ) endnode= root;

        n++;
        if(root.left!=null) parentmap.put(root.left,root);
        makeparentmap(root.left , parentmap , startValue,destValue);

        if(root.right!=null) parentmap.put(root.right,root);
        makeparentmap(root.right , parentmap , startValue,destValue);
    
    }

    private boolean path(TreeNode start , TreeNode end ,HashMap<TreeNode , TreeNode> parentmap,StringBuilder sb,boolean[] visited ){
        if(start==null || visited[start.val]) return false ;
        visited[start.val]=true;

        if(start==end) {
            return true;
        }

        boolean left = path(start.left,end,parentmap,sb,visited);
        boolean right = path(start.right,end,parentmap,sb,visited);
        boolean parent=false;
        if(parentmap.containsKey(start)) 
        parent = path(parentmap.get(start),end,parentmap,sb,visited);

        visited[start.val]=false;

        if(left) sb.append("L");
        if (right) sb.append("R");
        if(parent) sb.append("U");

        return left||right||parent;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        parentmap= new HashMap<>();
        makeparentmap(root,parentmap, startValue, destValue);

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        path(startnode,endnode,parentmap,sb,visited);
        return sb.reverse().toString();
    }
}