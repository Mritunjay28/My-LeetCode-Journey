class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n =matrix.length , m= matrix[0].length;
        int max =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    if(i>0) {
                        matrix[i][j]+=matrix[i-1][j];
                    }
                }
            }


            int[] currow = matrix[i].clone();
            Arrays.sort(currow);
            for(int j=0;j<m;j++){
                max = Math.max(max,currow[j]*(m-j));
            }
        }

        return max;
    }
}