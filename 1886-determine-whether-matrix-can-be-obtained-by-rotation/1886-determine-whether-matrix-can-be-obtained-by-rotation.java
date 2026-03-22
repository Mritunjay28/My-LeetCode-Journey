class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int k = 0;
        while (k < 4) {
            if (k != 0) {
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < n; j++) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[n - 1 - i][j];
                        mat[n - 1 - i][j] = temp;
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < i; j++) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[j][i];
                        mat[j][i] = temp;
                    }
                }
            }

            if (isEqual(mat, target))
                return true;
            k++;
        }

        return false;
    }

    public boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}