class Solution {
    class Pair {
        long f;
        long s;

        Pair() {
        this.f = -1;
        this.s = Integer.MAX_VALUE;
    }
        
        Pair(long fr,long sc){
            this.f=fr;
            this.s=sc;
        }
    }
    public int maxProductPath(int[][] grid) {
        int m = grid.length , n= grid[0].length;
        Pair[][] arr = new Pair[m][n];
        int mod = (int) 1e9+7;

        long val=1;
        for(int i=0;i<n;i++) {
            arr[0][i] = new Pair();
            val *= grid[0][i];
            arr[0][i].f = val;
            arr[0][i].s = val;
        }

        val=arr[0][0].f;
         for(int i=1;i<m;i++) {
            arr[i][0] = new Pair();
            val *= grid[i][0];
            arr[i][0].f = val;
            arr[i][0].s = val;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j] = new Pair();
                // upper 
                long first1 = arr[i-1][j].f , second1 = arr[i-1][j].s;
                // left
                long first2 = arr[i][j-1].f , second2 = arr[i][j-1].s;

                long max = Math.max(first1, first2);
                long min = Math.min(second1, second2);


                if(grid[i][j] >=0){
                    arr[i][j].f = (max*grid[i][j]);
                    arr[i][j].s = (min*grid[i][j]);
                }
                else{
                    arr[i][j].f = (min*grid[i][j]);
                    arr[i][j].s = (max*grid[i][j]);
                }
               

            }
        }


        if(arr[m-1][n-1].f <0) return -1;
        return (int) (arr[m-1][n-1].f % mod);
    }
}