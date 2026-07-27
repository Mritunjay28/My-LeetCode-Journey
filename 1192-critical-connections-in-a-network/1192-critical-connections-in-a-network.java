class Solution {
    int[] dt; // discovery time 
    int[] low; // lowest discovery time across neighbour except parent
    int time = 0;
    List<List<Integer>> ans;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ans = new ArrayList<>();
        dt = new int[n];
        low = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, visited);
            }
        }

        return ans;
    }

    public void dfs(int u, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;

        dt[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == parent)
                continue;

            if (!visited[v]) {
                dfs(v, u, adj, visited);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > dt[u]) { // bridge exist
                   ans.add(Arrays.asList(u, v));
                }
            }

            else if (visited[v] && v != parent) {
                low[u] = Math.min(low[u], dt[v]);
            }
        }
    }
}