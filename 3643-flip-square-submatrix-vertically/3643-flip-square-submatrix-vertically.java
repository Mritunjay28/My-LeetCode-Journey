class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int r1=x,c1=y;
        int r2=x+k-1,c2=y;
        int ce = y+k ,cs = y;
        int n = grid[0].length;

        while(r1<r2){
            int temp = grid[r1][c1];
            grid[r1][c1]=grid[r2][c2];
            grid[r2][c2]=temp;

            c2++;
            c1++;
            if(c2==ce){
                r1++;
                r2--;
                c2=cs;
                c1=cs;
            }
        }

        return grid;
    }
}