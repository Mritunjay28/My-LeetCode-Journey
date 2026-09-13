class Solution {

    // A moves right and down over B
    private int shiftRightDown(int[][] A, int[][] B, int xShift, int yShift, int N) {
        int count = 0;
        for (int i = 0; i < N - yShift; i++) {
            for (int j = 0; j < N - xShift; j++) {
                if (A[i][j] == 1 && B[i + yShift][j + xShift] == 1) count++;
            }
        }

        return count;
    }

    // A moves right and up over B
    private int shiftRightUp(int[][] A, int[][] B, int xShift, int yShift, int N) {
        int count = 0;
        for (int i = yShift; i < N; i++) {
            for (int j = 0; j < N - xShift; j++) {
                if (A[i][j] == 1 && B[i - yShift][j + xShift] == 1) count++;
            }
        }

        return count;
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int maxCount = 0;
        int N = A.length;

        for (int yShift = 0; yShift < N; yShift++) {
            for (int xShift = 0; xShift < N; xShift++) {

                // A moves down/right over B
                maxCount = Math.max(maxCount,shiftRightDown(A, B, xShift, yShift, N));

                // B moves down/right over A
                maxCount = Math.max(maxCount,shiftRightDown(B, A, xShift, yShift, N));

                // A moves up/right over B
                maxCount = Math.max(maxCount,shiftRightUp(A, B, xShift, yShift, N));

                // B moves up/right over A
                maxCount = Math.max(maxCount,shiftRightUp(B, A, xShift, yShift, N));
            }
        }

        return maxCount;
    }
}