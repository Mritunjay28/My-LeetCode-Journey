class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
         Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int max = 0;
        int n = s.length();

        while (!queue.isEmpty()) {
            int i = queue.poll();

            int start = Math.max(i + minJump, max + 1);
            int end = Math.min(i + maxJump + 1, n);

            for (int j = start; j < end; j++) {
                if (s.charAt(j) == '0') {
                    if (j == n - 1) return true;
                    queue.offer(j);
                }
            }

            max = i + maxJump;
        }

        return n == 1;
    }
}