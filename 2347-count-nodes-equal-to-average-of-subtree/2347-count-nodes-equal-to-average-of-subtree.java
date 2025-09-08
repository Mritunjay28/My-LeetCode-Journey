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

    // class Pair<U,V>{
    //     U first ;
    //     V second ; 

    //     Pair(U first , V second){
    //         this.first = first;
    //         this.second = second;
    //     }
    // }
    // // first = sum , second = no of node

    // int count=0;

    // private Pair<Integer,Integer> dfs(TreeNode root){
    //     if(root==null) return new Pair<>(0,0);

    //     Pair<Integer,Integer> left = dfs(root.left);
    //     Pair<Integer,Integer> right = dfs(root.right);

    //     int sum = left.first + right.first + root.val;
    //     int no = left.second+ right.second + 1;

    //     if(Math.floor(sum/no)==root.val) count++;

    //     return  new Pair<>(sum,no);
    // }


     int count=0;

    private int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = left[0] + right[0] + root.val;
        int no = left[1]+ right[1] + 1;

        if(Math.floor(sum/no)==root.val) count++;

        return  new int[]{sum,no};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }
}