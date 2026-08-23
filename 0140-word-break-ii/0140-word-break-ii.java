class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        backtrack(s, set, new StringBuilder(), ans, 0);
        return ans;
    }

    private void backtrack(String s, Set<String> set, StringBuilder curr, List<String> ans,
            int stidx) {

        if (stidx == s.length()) {
            ans.add(curr.toString().trim());
            return;
        }

        for (int endIndex = stidx + 1; endIndex <= s.length(); endIndex++) {
            String word = s.substring(stidx, endIndex);
            if (set.contains(word)) {
                int currlen = curr.length();
                curr.append(word).append(" ");
                backtrack(s, set, curr, ans, endIndex);
                curr.setLength(currlen);
            }
        }
    }
}