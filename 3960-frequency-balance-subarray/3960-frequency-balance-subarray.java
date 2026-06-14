class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> countOfFreq = new HashMap<>();

            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int num = nums[j];

                
                int old = freq.getOrDefault(num, 0);
                int newfreq = old + 1;
                freq.put(num, newfreq);

            
                if (old > 0) {
                    countOfFreq.put(old, countOfFreq.get(old) - 1);
                    if (countOfFreq.get(old) == 0) {
                        countOfFreq.remove(old);
                    }
                }
                countOfFreq.put(newfreq, countOfFreq.getOrDefault(newfreq, 0) + 1);

                
                maxFreq = Math.max(maxFreq, newfreq);

              
                int distinctFreqs = countOfFreq.size();

                if (distinctFreqs == 1) { 
                    // All elements have the exact same frequency like [5,5,5]
                    // If there are multiple distinct elements [1, 2] it's invalid.
                   if (countOfFreq.get(maxFreq) == 1) {
                        ans = Math.max(ans, j - i + 1);
                    }
                } else if (distinctFreqs == 2) { // Only two frequencies exist. One must be maxFreq, the other must be maxFreq / 2.
                    if (maxFreq % 2 == 0) {
                        int targetOtherFreq = maxFreq / 2;
                        if (countOfFreq.containsKey(targetOtherFreq)) {
                            ans = Math.max(ans, j - i + 1);
                        }
                    }
                }
            }
        }

        return ans;
    }
}