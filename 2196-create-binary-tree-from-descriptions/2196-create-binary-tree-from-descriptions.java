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
    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<TreeNode, TreeNode> left = new HashMap<>(); // node leftchild 
        HashMap<TreeNode, TreeNode> right = new HashMap<>(); // node rightChild 
        HashMap<Integer, TreeNode> nodes = new HashMap<>();

        HashSet<Integer> parent = new HashSet<>();
        HashSet<Integer> child = new HashSet<>();

        for (int[] d : descriptions) {

            int pVal = d[0];
            int cVal = d[1];
            int isLeft = d[2];

            nodes.putIfAbsent(pVal, new TreeNode(pVal));
            nodes.putIfAbsent(cVal, new TreeNode(cVal));

            TreeNode p = nodes.get(pVal);
            TreeNode c = nodes.get(cVal);

            parent.add(pVal);
            child.add(cVal);

            if (isLeft == 1) {
                left.put(p, c);
            } else {
                right.put(p, c);
            }
        }

        int rootVal = -1;

        for (int p : parent) {
            if (!child.contains(p)) {
                rootVal = p;
                break;
            }
        }

        TreeNode root = nodes.get(rootVal);
        dfs(root, left, right);

        return root;
    }

    public void dfs(TreeNode node, HashMap<TreeNode, TreeNode> left, HashMap<TreeNode, TreeNode> right) {
        if (left.containsKey(node)) {
            node.left = left.get(node);
            dfs(node.left, left, right);
        }

        if (right.containsKey(node)) {
            node.right = right.get(node);
            dfs(node.right, left, right);
        }
    }
}