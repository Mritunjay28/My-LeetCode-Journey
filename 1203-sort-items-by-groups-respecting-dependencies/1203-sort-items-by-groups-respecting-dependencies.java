class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        // Give every ungrouped item a unique group id
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Item graph
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) itemGraph.add(new ArrayList<>());
        int[] itemIndegree = new int[n];

        // Group graph
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < m; i++) groupGraph.add(new ArrayList<>());
        int[] groupIndegree = new int[m];

        // Build both graphs
        for (int v = 0; v < n; v++) {
            for (int u : beforeItems.get(v)) {

                // item graph
                itemGraph.get(u).add(v);
                itemIndegree[v]++;

                // group graph
                if (group[u] != group[v]) {
                    groupGraph.get(group[u]).add(group[v]);
                    groupIndegree[group[v]]++;
                }
            }
        }

        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree);
        if (itemOrder.size() != n) return new int[0];

        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);
        if (groupOrder.size() != m) return new int[0];

        // Store items according to item topo order
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int item : itemOrder) {
            map.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        int[] ans = new int[n];
        int idx = 0;

        // Output groups in group topo order
        for (int g : groupOrder) {
            if (!map.containsKey(g)) continue;

            for (int item : map.get(g)) {
                ans[idx++] = item;
            }
        }

        return ans;
    }

    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();
            order.add(node);

            for (int next : graph.get(node)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return order;
    }

}