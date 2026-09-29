class Solution {
    StringBuilder sb = new StringBuilder();
    int[] start;
    int[] end;
    int timer = 0;

    public boolean[] findAnswer(int[] parent, String s) {
        int n = parent.length;

        start = new int[n];
        end = new int[n];

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        dfs(0, adj, s);

        int[] radius = manacher(sb.toString());

        boolean[] ans = new boolean[n];

        for (int u = 0; u < n; u++) {

            int l = start[u];
            int r = end[u];

            int len = r - l + 1;

            // Correct center in transformed string
            int center = l + r + 1;

            ans[u] = radius[center] >= len;
        }

        return ans;
    }

    private void dfs(int u, List<Integer>[] adj, String s) {

        start[u] = timer;

        for (int v : adj[u]) {
            dfs(v, adj, s);
        }

        sb.append(s.charAt(u));

        end[u] = timer;
        timer++;
    }

    private int[] manacher(String str) {

        int n = str.length();

        char[] t = new char[2 * n + 1];

        for (int i = 0; i < t.length; i++) {
            if (i % 2 == 0) {
                t[i] = '#';
            } else {
                t[i] = str.charAt(i / 2);
            }
        }

        int[] p = new int[t.length];

        int center = 0;
        int right = 0;

        for (int i = 0; i < t.length; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (
                i - p[i] - 1 >= 0 &&
                i + p[i] + 1 < t.length &&
                t[i - p[i] - 1] == t[i + p[i] + 1]
            ) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        return p;
    }
}
/*
doing dfs for each is o(n^2) which is not possible 
so we locate start and end of each index .

so , for palindeomr check we have do the maneswar to palindri=omr in o(1) 
so if we cannot do:

 for (int len = 2; len <= n; len++) {
    for (int l = 0; l + len - 1 < n; l++) {
            int r = l + len - 1;
            dp[l][r] = (s.charAt(l) == s.charAt(r)) && (r - l <= 2 || dp[l + 1][r - 1]);
    }
}

as o(n^2) , so have to do mancheswar.
*/