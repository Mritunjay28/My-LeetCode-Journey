class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, TreeSet<long[]>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new TreeSet<long[]>(
                    (x, y) -> {
                        if (x[0] != y[0])
                            return Long.compare(x[0], y[0]);
                        return Long.compare(x[1], y[1]);
                    }));

            map.get(nums[i]).add(new long[] { i, i, 0 }); // [index, prefix, pos]
        }

        for (Map.Entry<Integer, TreeSet<long[]>> entry : map.entrySet()) {
            TreeSet<long[]> set = entry.getValue();

            long[] prev = null;
            int pos = 0;
            for (long[] curr : set) {
                if (prev != null) {
                    curr[1] += prev[1];
                }
                prev = curr;
                curr[2] = pos++;
            }
        }

        long[] ans = new long[nums.length];

        for (int i = 0; i < ans.length; i++) {
            TreeSet<long[]> set = map.get(nums[i]);

            long[] key = new long[] { i, Long.MIN_VALUE };

            long[] res = set.ceiling(key);

            if (res != null && res[0] == i) {

                int less = (int) res[2];
                int greater = set.size() - less - 1;

                long sumLeft = (long) less * i - (res[1] - i);

                long[] last = set.last();
                long sumRight = (last[1] - res[1]) - (long) greater * i;

                ans[i] = sumLeft + sumRight;
            } else
                ans[i] = 0;
        }

        return ans;
    }
}
/*

1- 0,2,4,5,6
1- 0-0,2-2,4-6,5-11,6-17

so 12-6 + 11-8 = 6+3=9
4+2+0+1+2=9

*/