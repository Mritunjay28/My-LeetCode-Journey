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

    int idx;

    private TreeNode dfs(String t , int level){
        if(idx>=t.length()) return null;

        int val = 0;
while (idx < t.length() && Character.isDigit(t.charAt(idx))) {
    val = val * 10 + (t.charAt(idx) - '0');
    idx++;
}
        TreeNode root = new TreeNode(val);
        int count=0;
        int tempidx=idx; // tempidx because if suppose you count - and it less then current then you go back
        // but as idx is global we lose the value due to direct update globaly
        // so we keep trmpidx and only increase idx when we get an answer 
        while(tempidx<t.length() && t.charAt(tempidx)=='-') {
            count++;
            tempidx++;
            }
        if(count==level+1){
            idx=tempidx;
            root.left = dfs(t,level+1);
        } 
        // else return root;
        count=0;
        tempidx=idx;
        while(tempidx<t.length() && t.charAt(tempidx)=='-') {
            count++;
            tempidx++;
            }
        if(count==level+1){
            idx=tempidx;
            root.right = dfs(t,level+1);
        } 
        // else return root;

        return root;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        idx=0;
        return dfs(traversal,0);
    }
}