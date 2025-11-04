class Solution {
    int[] ans;
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
       Map<Integer, Integer> freqMap = new HashMap<>();
        ans= new int[n-k+1];
        int l = 0;
        int i=0;
        for (int r = 0; r < n; r++) {
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r], 0) + 1);

            while (l < r && (r - l + 1) > k) {
                freqMap.put(nums[l], freqMap.get(nums[l]) - 1);
                if (freqMap.get(nums[l]) == 0)
                    freqMap.remove(nums[l]);
                l++;
            }

            if ((r - l + 1) == k) {
               ans[i++]=find(freqMap, x);
            }
        }

        return ans;

    }
      private int find(Map<Integer, Integer> freqMap, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];   // freq desc
            return b[1] - a[1];                     // value desc
        });

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int sum = 0;
        while (x-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int freq = top[0];
            int num = top[1];
            sum += num * freq;
        }
        return sum;
    }

}