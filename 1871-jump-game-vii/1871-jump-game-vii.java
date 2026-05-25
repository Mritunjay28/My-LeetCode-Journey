class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] visited = new boolean[s.length()];
        visited[0] = true;

        int farthest = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                continue;
            }

            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, s.length() - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    visited[j] = true;
                }
            }

            farthest = end;
        }

        return visited[s.length() - 1];
    }
}