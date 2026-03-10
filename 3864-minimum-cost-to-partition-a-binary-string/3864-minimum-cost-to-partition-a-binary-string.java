class Solution {
    public long minCost(String s, int encCost, int flatCost) {
        return dfs(s, 0, s.length() - 1, encCost, flatCost);
    }

    private long dfs(String s, int l, int r, int encCost, int flatCost) {
        if (l > r)
            return 0;

        int n = r - l + 1;
        int sen = 0;

        for (int i = l; i <= r; i++)
            if (s.charAt(i) == '1')
                sen++;

        long cost;
        if (sen == 0)
            cost = flatCost;
        else
            cost = (long) n * sen * encCost;

        if (n % 2 == 1)
            return cost;

        int mid = (l + r) / 2;

        long split = dfs(s, l, mid, encCost, flatCost)
                   + dfs(s, mid + 1, r, encCost, flatCost);

        return Math.min(cost, split);
    }
}