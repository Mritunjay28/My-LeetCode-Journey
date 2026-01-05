class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0,min=10000000;
        int negcount=0;
        for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]<0) negcount++;
            sum+=Math.abs(matrix[i][j]);
            min=Math.min(min,Math.abs(matrix[i][j]));
           }
        }

        if(negcount%2!=0) sum-=(2*min);

        return sum; 
    }
}

