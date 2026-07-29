class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int x : stones) map.put(x, i++);

        Queue<int[]> q = new LinkedList<>();

        if (stones[0] + 1 != stones[1]) return false;

        HashSet<String> visited = new HashSet<>();
        visited.add("1,1");

        q.add(new int[] { 1, 1 });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            i = curr[0];
            int k = curr[1];

            if (i == stones.length - 1)return true;

            for (int jump = k - 1; jump <= k + 1; jump++) {

                if (jump <= 0)continue;
                int nextPos = stones[i] + jump;

                if (map.containsKey(nextPos)) {
                    int nextIndex = map.get(nextPos);
                    String state = nextIndex + "," + jump;
                    if (!visited.contains(state)) {
                        visited.add(state);
                        q.add(new int[] { nextIndex, jump });
                    }
                }
            }
        }

        return false;
    }
}