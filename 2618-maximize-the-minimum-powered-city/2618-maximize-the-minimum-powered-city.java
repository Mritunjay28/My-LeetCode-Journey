class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long sum = 0;
      
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - r);
            int end = Math.min(n - 1, i + r);
            diff[start] += stations[i];
            if (end + 1 < n) diff[end + 1] -= stations[i];
            sum += stations[i];
        }

        for (int i = 1; i < n; i++) diff[i] += diff[i - 1];

        
        long s = 0, e = sum+k, ans = 0;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (ispossible(mid, diff, r, k)) {
                ans = mid;
                s = mid + 1;
            } else
                e = mid - 1;
        }
        return ans;
    }

    private boolean ispossible(long mid ,long[] base, int r, long k ){
        int n= base.length;
        long[] diff = new long[n];
        long currAdd = 0;

        for (int i = 0; i < n; i++) {
            currAdd += diff[i];
            long currPower = base[i] + currAdd;

            if (currPower < mid) {
                long need = mid - currPower;
                k -= need;
                if (k < 0) return false;

                currAdd += need;
                if (i + 2 * r + 1 < n) diff[i + 2 * r + 1] -= need;
            }
        }
        return true;
    }
}