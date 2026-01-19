class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m= mat.length , n=mat[0].length;
        int[][] ps = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = mat[i-1][j-1] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
            }
        }

        int min_side = Math.min(m,n); //3

        while(min_side > 0){ //300
            for(int i=0;i<m;i++){ //300
                for(int j=0;j<n;j++){ //300
                    if(i+min_side<=m && j+min_side<=n){ 
                        int sum = ps[i+min_side][j+min_side] -ps[i][j+min_side] - ps[i+min_side][j]+ps[i][j];
                        if(sum<=threshold) return min_side;
                    }
                }
            }
            min_side--;
        }

        return 0;
    }

}