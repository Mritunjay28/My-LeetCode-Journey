class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> previousEvents = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int maxValPreviousEvents = 0, globalMax = 0;
        for (int[] currentEvent : events) {

            while (!previousEvents.isEmpty()) {
                int start = currentEvent[0];
                if (start <= previousEvents.peek()[0]) {
                    break;
                }
                int[] previousEvent = previousEvents.remove();
                maxValPreviousEvents = Math.max(maxValPreviousEvents, previousEvent[1]);
            }

            globalMax = Math.max(globalMax, currentEvent[2] + maxValPreviousEvents);
            previousEvents.add(new int[]{currentEvent[1], currentEvent[2]});
        }

        return globalMax;
    }
}