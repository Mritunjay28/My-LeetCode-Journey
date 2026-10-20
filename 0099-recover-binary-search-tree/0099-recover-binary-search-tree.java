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
    List<TreeNode> arr;
    public void recoverTree(TreeNode root) {
        arr = new ArrayList<>();
        dfs(root);
        List<TreeNode> arr2 = new ArrayList<>();
        for(int i=0;i<arr.size();i++) arr2.add(arr.get(i));
        Collections.sort(arr2,(a,b) -> Integer.compare(a.val, b.val));
        TreeNode first=null;
        TreeNode last=null;
        for(int i=0;i<arr2.size();i++){
            if(arr.get(i).val != arr2.get(i).val){
                if(first==null) first = arr.get(i);
                else{
                    last=arr.get(i);
                    break;
                }
            }
        }

        int temp=first.val;
        first.val=last.val;
        last.val=temp;
    }

    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        arr.add(node);
        dfs(node.right);

    }
}