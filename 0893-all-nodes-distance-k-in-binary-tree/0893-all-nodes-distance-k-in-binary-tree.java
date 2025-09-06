/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void makeParentMap(TreeNode root,HashMap<TreeNode ,TreeNode> parentmap) {
        if (root == null)return;

        if(root.left!=null) parentmap.put(root.left,root);
        makeParentMap(root.left,parentmap);

       
        if(root.right!=null) parentmap.put(root.right,root);
        makeParentMap(root.right,parentmap);

    }

    private void travel( TreeNode target, int k ,  List<Integer> ans,HashMap<TreeNode ,TreeNode> parentmap, HashSet<TreeNode> visited){
        if(target==null || visited.contains(target)) return ;
        visited.add(target);
        if(k==0) {
            ans.add(target.val);
            return ;
        }
        travel(target.left,k-1,ans,parentmap,visited);
        travel(target.right,k-1,ans,parentmap,visited);
        travel(parentmap.get(target),k-1,ans,parentmap,visited);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode ,TreeNode> parentmap = new HashMap<>();

        makeParentMap(root,parentmap);

        travel(target , k , ans,parentmap,new HashSet<>());
        return ans;
    }
}