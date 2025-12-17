class NumMatrix {

    int[][] arr ;
    public NumMatrix(int[][] matrix) {
        arr= new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
               if(i==0 && j==0) arr[i][j] = matrix[i][j];
               else if(i==0 && j!=0) arr[i][j] = arr[i][j-1] + matrix[i][j];
               else if(i!=0 && j==0) arr[i][j] = arr[i-1][j] + matrix[i][j];
               else{
                arr[i][j]= matrix[i][j]+arr[i-1][j] + arr[i][j-1]-arr[i-1][j-1] ;
               } 
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
       int a =0,b=0,c=0;
       if(row1-1>=0) a= arr[row1-1][col2];
       if(col1-1>=0) b= arr[row2][col1-1];
       if(row1-1>=0 && col1-1>=0) c= arr[row1-1][col1-1];
       return arr[row2][col2] -a-b+c;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */