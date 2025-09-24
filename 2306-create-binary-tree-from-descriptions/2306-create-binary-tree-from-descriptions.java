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
    public TreeNode createBinaryTree(int[][] d) {
        // parentmap<self,parent>
        HashMap<TreeNode,TreeNode> parentmap = new HashMap<>();
        HashMap<Integer,TreeNode> nodemap = new HashMap<>();

        for(int i=0;i<d.length ; i++){
            TreeNode curr= new TreeNode();
            if(nodemap.containsKey(d[i][0])){
                curr=nodemap.get(d[i][0]);
            }
            else{
                curr=new TreeNode(d[i][0]);
                nodemap.put(d[i][0],curr);
            }

            TreeNode child =new TreeNode();
            if(nodemap.containsKey(d[i][1])) {
                child = nodemap.get(d[i][1]);
               
            }
            else{
                 child =new TreeNode(d[i][1]);
                nodemap.put(d[i][1],child);
            }

            if(d[i][2]==1) curr.left=child;
            else curr.right=child;

            parentmap.put(child,curr);
            if(!parentmap.containsKey(curr)) parentmap.put(curr,null);
        }

        for(Map.Entry<TreeNode,TreeNode> entry : parentmap.entrySet()){
            if(entry.getValue()==null) return entry.getKey();
        }


        return null;
        
    }
}