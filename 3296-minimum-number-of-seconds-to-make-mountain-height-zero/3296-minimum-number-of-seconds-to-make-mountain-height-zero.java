class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        Arrays.sort(workerTimes);
        long ans = 0;
        long s = 0, e = (long)1e18;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (ispossible(mountainHeight, workerTimes, mid)) {
                ans = mid;
                e = mid - 1;
            } else
                s = mid + 1;
        }
        return ans;
    }

    public boolean ispossible(long h, int[] arr, long k) {
        long cal =0;
        for (int i = 0; i < arr.length; i++) {
            long val = arr[i];
            long S = k / val;
            long n = (long) ((-1 + Math.sqrt(1 + 8.0 * S)) / 2);
            while (val * (n * (n + 1) / 2) > k) n--;
            while (val * ((n + 1) * (n + 2) / 2) <= k) n++;

            cal+=n;
            if(cal>=h) return true;
        }

        if(cal>=h) return true;
        return false;
    }
}