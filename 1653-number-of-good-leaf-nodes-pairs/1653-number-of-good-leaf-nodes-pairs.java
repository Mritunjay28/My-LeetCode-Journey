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
    int count=0;
    private ArrayList<Integer> paircount(TreeNode root, int distance){
        if(root==null) return new ArrayList<>();


        if(root.left==null && root.right==null) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            return arr;
        }

        ArrayList<Integer> left = paircount(root.left,distance);
        ArrayList<Integer> right = paircount(root.right,distance);
        ArrayList<Integer> merge = new ArrayList<>();

        for(int i=0;i<left.size();i++){
            for(int j=0;j<right.size();j++){
                if(left.get(i)+right.get(j) <= distance) count++;
            }
        }

         for(int l :left){
            if(l+1 <= distance) merge.add(l+1);
         }
          for(int r :right){
            if(r+1 <= distance) merge.add(r+1);
         }


        return merge;
    }
    public int countPairs(TreeNode root, int distance) {
        paircount(root,distance);
        return count;
    }
}