import java.util.*;

class Solution {
    int[] parent, rank;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        rank = new int[c];
        for (int i = 0; i < c; i++) parent[i] = i;

        for (int[] edge : connections) {
            union(edge[0] - 1, edge[1] - 1);
        }

        Map<Integer, TreeSet<Integer>> grid = new HashMap<>();
        for (int i = 0; i < c; i++) {
            int root = find(i);
            grid.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c];
        Arrays.fill(online, true);

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1] - 1;
            int root = find(x);

            if (type == 1) {
                if (online[x]) ans.add(x + 1);
                else {
                    TreeSet<Integer> set = grid.get(root);
                    if (set == null || set.isEmpty()) ans.add(-1);
                    else ans.add(set.first() + 1); 
                }
            } else {
                if (!online[x]) continue;
                online[x] = false;
                grid.get(root).remove(x);
            }
        }

    
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;

        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
