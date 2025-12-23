class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int max = -1;
        for (int i = 0; i < segments.length; i++)
            max = Math.max(segments[i][1], max);

        long[] arr = new long[max + 1];

        boolean[] boundary = new boolean[max + 1];

        for (int i = 0; i < segments.length; i++) {
            arr[segments[i][0]] += segments[i][2];
            arr[segments[i][1]] -= segments[i][2];
            boundary[segments[i][0]] = true;
            boundary[segments[i][1]] = true;
        }

        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];

        List<List<Long>> ans = new ArrayList<>();

        int prev = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && prev == -1) {
                prev = i;
            } else if (prev != -1 && (arr[i] != arr[prev] || boundary[i])) {
                ans.add(Arrays.asList((long) prev, (long) i, arr[prev]));
                prev = arr[i] == 0 ? -1 : i;
            }
        }

        return ans;
    }
}
