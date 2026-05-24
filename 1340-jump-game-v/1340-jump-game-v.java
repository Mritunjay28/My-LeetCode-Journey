class Solution {
    int[] memo = new int[1001];

    public int maxJumps(int[] arr, int d) {
        int ans = 1;

        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(i, arr, d));
        }

        return ans;
    }

    public int dfs(int idx, int[] arr, int d) {
        if (memo[idx] != 0) return memo[idx];

        int best = 1;

        // left
        for (int i = idx - 1; i >= Math.max(0, idx - d); i--) {
            if (arr[i] >= arr[idx]) break;
            best = Math.max(best, 1 + dfs(i, arr, d));
        }

        // right
        for (int i = idx + 1; i <= Math.min(arr.length - 1, idx + d); i++) {
            if (arr[i] >= arr[idx]) break;
            best = Math.max(best, 1 + dfs(i, arr, d));
        }

        memo[idx] = best;
        return best;
    }
}