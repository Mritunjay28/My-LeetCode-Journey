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

    class Pair<U,V>{
        U first ;
        V second ; 

        Pair(U first , V second){
            this.first = first;
            this.second = second;
        }
    }
    // first = sum , second = no of node

    int count=0;

    private Pair<Integer,Integer> dfs(TreeNode root){
        if(root==null) return new Pair<>(0,0);

        Pair<Integer,Integer> left = dfs(root.left);
        Pair<Integer,Integer> right = dfs(root.right);

        int sum = left.first + right.first + root.val;
        int no = left.second+ right.second + 1;

        if(Math.floor(sum/no)==root.val) count++;

        return  new Pair<>(sum,no);
    }


    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }
}