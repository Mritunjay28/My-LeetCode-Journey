class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        String[] sec = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums1[i]; j++) sb.append('1');
            for (int j = 0; j < nums0[i]; j++) sb.append('0');
            sec[i] = sb.toString();
        }

    
        Arrays.sort(sec, (a, b) -> (b + a).compareTo(a + b));

        long MOD = (long) 1e9+7;
        long result = 0;

        for (String segment : sec) {
            for (int i = 0; i < segment.length(); i++) {
                int bit = segment.charAt(i) - '0';
                result = (result * 2 + bit) % MOD;
            }
        }

        return (int) result;
    }
}