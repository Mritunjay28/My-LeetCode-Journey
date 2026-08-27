class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) freq[c - 'a']++;
        

        // Try from right to left.0
        // want latest possible position to become bigger.
        for (int i = target.length() - 1; i >= 0; i--) {
            int[] cnt = freq.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';
                if (cnt[x] == 0) {
                    possible = false;
                    break;
                }
                cnt[x]--;
            }

            if (!possible) continue;

            // At position i, find smallest char > target[i]
            int x = target.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (cnt[c] > 0) {

                    cnt[c]--;

                    StringBuilder ans = new StringBuilder(target.substring(0, i));

                    ans.append((char) ('a' + c));

                    // Remaining chars in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (cnt[k] > 0) {
                            ans.append((char) ('a' + k));
                            cnt[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}