class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] result = new int[n];
        int[] count = new int[n];

        dfs1(0, -1, adj, count, result);  
        dfs2(0, -1, adj, count, result, n); 

        return result;
    }

    private void dfs1(int u, int parent, List<List<Integer>> adj, int[] count, int[] result) {
        count[u] = 1;
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            dfs1(v, u, adj, count, result);
            count[u] += count[v];
            result[u] += result[v] + count[v];
        }
    }

    private void dfs2(int u, int parent, List<List<Integer>> adj, int[] count, int[] result, int n) {
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            result[v] = result[u] - count[v] + (n - count[v]);
            dfs2(v, u, adj, count, result, n);
        }
    }
}