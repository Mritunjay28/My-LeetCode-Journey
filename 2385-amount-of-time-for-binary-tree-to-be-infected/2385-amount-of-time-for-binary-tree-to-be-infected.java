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
    TreeNode target;
    private void makeparentmap(TreeNode root, HashMap<TreeNode,TreeNode> parentmap,int k){
        if(root==null) return ;

        if(root.left!=null) parentmap.put(root.left,root);
        makeparentmap(root.left,parentmap,k);

        if(root.val==k) target= root;
         if(root.right!=null) parentmap.put(root.right,root);
        makeparentmap(root.right,parentmap,k);
    }

    private int travel(TreeNode target ,  HashMap<TreeNode,TreeNode> parentmap , int level , HashSet<TreeNode> visited ){
        if(target==null || visited.contains(target)) return level;
        visited.add(target);

        int left = travel(target.left , parentmap , level,visited); 
        int right = travel(target.right , parentmap , level,visited); 
        int parent = travel(parentmap.get(target) , parentmap , level,visited); 

        return Math.max(left,Math.max(right,parent))+1;
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parentmap = new HashMap<>();
        makeparentmap(root,parentmap,start);

        return  travel(target,parentmap,0,new HashSet<>())-1;
    }
}