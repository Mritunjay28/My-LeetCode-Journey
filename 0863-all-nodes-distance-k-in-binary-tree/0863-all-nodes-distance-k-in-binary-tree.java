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
    HashMap<TreeNode,TreeNode> parent;
    HashSet<TreeNode> visited;
    List<Integer> arr;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        parent.put(root,null);
        dfs(root);

        arr = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target);
        travel(target,k);
        return arr;

    }

    public void travel(TreeNode node , int k){
        if(k==0) {
            arr.add(node.val);
            return ;
        }

        if(node.left!=null && !visited.contains(node.left)){
            visited.add(node.left);
            travel(node.left,k-1);
        } 
        if(node.right!=null && !visited.contains(node.right)){
            visited.add(node.right);
            travel(node.right,k-1);
        }  
        if(parent.get(node)!=null && !visited.contains(parent.get(node))){
            visited.add(parent.get(node));
            travel(parent.get(node),k-1);
        } 
    }

    public void dfs(TreeNode node){
        if(node.left!=null){
            parent.put(node.left,node);
            dfs(node.left);
        }
        if(node.right!=null){
            parent.put(node.right,node);
            dfs(node.right);
        }
    }
}