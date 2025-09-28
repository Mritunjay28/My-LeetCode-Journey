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

    private int countswap(ArrayList<Integer> arr){
        ArrayList<Integer> copy = new ArrayList<>(arr);
        Collections.sort(copy);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            map.put(arr.get(i),i);
        }

        int swap=0;
        for(int i=0;i<arr.size();i++){
            if(!arr.get(i).equals(copy.get(i))){
                int swapperidx = map.get(copy.get(i));
                int temp=arr.get(i);
               arr.set(i, arr.get(swapperidx));
arr.set(swapperidx, temp);

                map.put(arr.get(swapperidx),swapperidx);
                map.put(arr.get(i),i);
                swap++;
            }
        }
        return swap;

    }

    // 5678
    // 7685



    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        int totalswap=0;
        while(!q.isEmpty()){
            int len= q.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode curr = q.poll();
                arr.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            totalswap+= countswap(arr);
        }
        return totalswap;
    }
}