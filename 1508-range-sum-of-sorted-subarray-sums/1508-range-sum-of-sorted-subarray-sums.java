class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums[i]});
        }
        int count = 1;
        long res = 0;
        long mod = 1000000007;
        while (!pq.isEmpty() && count <= right) {
            int[] temp = pq.poll();
            if (count >= left) {
                res += temp[1];
                res %= mod;
            }
            count++;
            if (temp[0] == 0) {
                continue;
            }
            temp[0]--;
            temp[1] += nums[temp[0]];
            pq.offer(temp);
        }
        return (int) res;
    }
}