class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
             map.put((long) nums[i],map.getOrDefault((long) nums[i],0)+1);
        }

        int ans = 1;

        // Handle 1 separately
        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            ans = Math.max(ans, (cnt % 2 == 1) ? cnt : cnt - 1);
        }


        for (long num : map.keySet()) {
            if (num == 1L)
                continue;

            long x = num;
            int len = 0;

            while (map.containsKey(x) && map.get(x) >= 2) {
                len += 2;

                if (x > 1_000_000_000L) break; // overflow

                x = x * x;
            }

            if (map.containsKey(x))
                len++;
            else
                len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}