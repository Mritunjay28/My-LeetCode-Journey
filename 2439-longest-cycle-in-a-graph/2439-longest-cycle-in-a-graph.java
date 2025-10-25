class Solution {
    int max = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] inrecursion = new int[n];
        Arrays.fill(inrecursion, -1);
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(i, edges, visited, inrecursion, 0);
        }
        return max;
    }

    private void dfs(int u, int[] edges, boolean[] visited, int[] inrecursion, int count) {
        if (visited[u]) return;

        visited[u] = true;
        inrecursion[u] = count;
        count++;

        if (edges[u] != -1) {
            if (inrecursion[edges[u]] != -1)
                max = Math.max(max, count - inrecursion[edges[u]]);
            else
                dfs(edges[u], edges, visited, inrecursion, count);
        }
        inrecursion[u] = -1;
    }
}

// where each node has at most one outgoing edge. 
// -> this line tell us that we cannot have cycle merge with each other 