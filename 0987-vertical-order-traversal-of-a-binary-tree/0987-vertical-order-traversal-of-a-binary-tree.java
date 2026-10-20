
class Solution {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();

        dfs(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            ans.add(column);
        }

        return ans;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

        map.computeIfAbsent(col, k -> new TreeMap<>())
           .computeIfAbsent(row, k -> new PriorityQueue<>())
           .offer(node.val);

        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}
