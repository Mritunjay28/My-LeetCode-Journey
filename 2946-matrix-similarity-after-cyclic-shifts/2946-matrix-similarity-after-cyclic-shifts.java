class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n =mat[0].length;
        for (int i = 0; i < mat.length; i++) {

            int idx = k % n;

            if (idx == 0) continue;
            for (int j = 0; j < n; j++) {
                // even idx 
                if (i % 2 == 0) {
                    if (mat[i][idx] != mat[i][j]) return false;
                    idx++;
                    if (idx >= n) idx = 0;
                }

                if (i % 2 != 0) {
                    if (j == 0) idx = (n - (k % n)) % n;
                    if (mat[i][idx] != mat[i][j]) return false;
                    idx++;
                    if (idx >= n) idx = 0;
                }

            }
        }

        return true;
    }
}

/*
[9,1,8,9,2,9,1,8,9,2]
[10,2,7,8,9,10,2,7,8,9]
[7,6,6,9,5,7,6,6,9,5]   

[9,1,8,9,2,9,1,8,9,2]
[10,2,7,8,9,10,2,7,8,9]
[7,6,6,9,5,7,6,6,9,5]  
*/