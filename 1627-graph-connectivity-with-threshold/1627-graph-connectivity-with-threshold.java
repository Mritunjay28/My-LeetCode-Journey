class Solution {
    int[] parent;
    int[] rank;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        rank = new int[n];

        for (int d = threshold + 1; d <= n; d++) {
            for (int multiple = 2 * d; multiple <= n; multiple += d) {
                union(d - 1, multiple - 1); // 0-based indexing
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;

            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                ans.add(true);
            else
                ans.add(false);
        }

        return ans;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    void union(int x, int y) {
        int xparent = find(x);
        int yparent = find(y);

        if (xparent == yparent)
            return;

        if (rank[xparent] > rank[yparent]) {
            parent[yparent] = xparent;
        } else if (rank[xparent] < rank[yparent]) {
            parent[xparent] = yparent;
        } else {
            parent[yparent] = xparent;
            rank[xparent]++;
        }
    }

    int find(int value) {
        if (value == parent[value]) {
            return value;
        }
        return parent[value] = find(parent[value]);
    }
}