class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int count = 0;
        int pos = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return b[1] - a[1];
            else
                return a[0] - b[0];
        });
        int i = 0;
        while (pos < target && i < stations.length) {
            if (pos + startFuel >= target) return count;

            while (!pq.isEmpty() && stations[i][0] > pos + startFuel) {
                int[] temp = pq.poll();
                startFuel += temp[1];
                count++;
            }
            if (stations[i][0] > pos + startFuel)
                return -1;

            if (stations[i][0] <= pos + startFuel) {
                int diff = stations[i][0] - pos;
                pos += diff;
                startFuel -= diff;
            }

            pq.add(new int[] { stations[i][0], stations[i][1] });
            i++;
        }

         while (!pq.isEmpty() && target > pos + startFuel) {
                int[] temp = pq.poll();
                startFuel += temp[1];
                count++;
            }
          if (pos + startFuel >= target) return count;

          return -1;

    }
}