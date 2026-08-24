class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        int[] arr = new int[n];
        arr[n - 1] = prefix[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            arr[i] = Math.max(arr[i + 1], prefix[i] - arr[i + 1]);
        }
        return arr[1];
    }
}