class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] champ =new double[102][102];
        champ[0][0]=poured;
        for(int i=0;i<=query_row;i++){
            for(int j=0;j<=i;j++){
                double q = (champ[i][j] -1.0) / 2.0;
                if(q>0){
                    champ[i+1][j]+=q;
                    champ[i+1][j+1]+=q;
                }
            }
        }

        return Math.min(1,champ[query_row][query_glass]);
    }
}
/*
1 row 1 cup 
2nd row 2 cup - total 3 
3rd row 4 cup - total 7 with excess 1 overflow by midddle glass 0.5 left and right both 
4th row 
*/