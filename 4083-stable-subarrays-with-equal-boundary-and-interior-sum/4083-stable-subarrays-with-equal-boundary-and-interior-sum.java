class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
    long ans = 0;
    long prefix = 0;
    Map<String, Integer> map = new HashMap<>();

    long[] pref = new long[n];
    for (int i = 0; i < n; i++) {
        prefix += capacity[i];
        pref[i] = prefix;
    }

    for (int r = 0; r < n; r++) {
        long target = pref[r] - 3L * capacity[r];
        String lookup = capacity[r] + "," + target;
        ans += map.getOrDefault(lookup, 0);

        if (r >= 1) {
            long keyPrefix = (r >= 2) ? pref[r - 2] : 0;
            String insert = capacity[r - 1] + "," + keyPrefix;
            map.put(insert, map.getOrDefault(insert, 0) + 1);
        }
    }
    return ans;
    }
}

// arr =>  1,2,3,4,5
//prefix=> 1,3,6,10,15
/* [l,r]
r-l+1 >=3 
r-l>=2
r>=l+2 to this add delay
capacity[l]==capacity[r]
so sum of subaaray = 3* capacity[l/r]
then prefix[r] - prefix[l-1] = capacity[l] but as we have capacity[l] = capacity[r] so we replace capacity[r]
by doing this we solve both equation
prefix[r] - prefix[l-1] = capacity[r]
prefix[l-1] = prefix[r] - capacity[r]
*/