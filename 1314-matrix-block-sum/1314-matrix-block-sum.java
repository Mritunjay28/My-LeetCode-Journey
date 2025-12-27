class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                else if(i>0 && j==0) mat[i][j] += mat[i-1][j];
                else if(i==0 && j>0) mat[i][j] += mat[i][j-1];
                else mat[i][j] += mat[i-1][j]+ mat[i][j-1] -mat[i-1][j-1];
            }
        }

        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                int total = mat[r2][c2];
                if (r1 > 0) total -= mat[r1 - 1][c2];
                if (c1 > 0) total -= mat[r2][c1 - 1];
                if (r1 > 0 && c1 > 0) total += mat[r1 - 1][c1 - 1];

                ans[i][j] = total;                                      
            }
        }

        return ans;
    }
}