class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        HashMap<Integer, List<Character>> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                map.computeIfAbsent(freq[i], k -> new ArrayList<>()).add((char)(i + 'a'));
            }
        }

        int bestFreq = -1;
        int maxGroupSize = -1;

        for (Map.Entry<Integer, List<Character>> e : map.entrySet()) {
            int k = e.getKey();
            int size = e.getValue().size();

            if (size > maxGroupSize || (size == maxGroupSize && k > bestFreq)) {
                maxGroupSize = size;
                bestFreq = k;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : map.get(bestFreq)) {
            result.append(c);
        }

        return result.toString();
    }
}
