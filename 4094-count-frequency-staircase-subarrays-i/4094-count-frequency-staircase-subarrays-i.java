class Solution {
    public int countStaircase(int[] nums) {
         int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            HashMap<Integer, Integer> freq = new HashMap<>();
            HashMap<Integer, Integer> rank = new HashMap<>();

            int distinct = 0;
            int bad = 0;

            for (int j = i; j < n; j++) {
                int x = nums[j];

                if (!freq.containsKey(x)) {
                    distinct++;

                    freq.put(x, 1);
                    rank.put(x, distinct);

                    if (distinct != 1) bad++;
                } else {
                    int oldFreq = freq.get(x);
                    int r = rank.get(x);

                    if (oldFreq != r) bad--;
                    
                    int newFreq = oldFreq + 1;
                    freq.put(x, newFreq);

                    if (newFreq != r) bad++;
                }

                if (bad == 0) ans++;
            }
        }

        return ans;
    }
}
