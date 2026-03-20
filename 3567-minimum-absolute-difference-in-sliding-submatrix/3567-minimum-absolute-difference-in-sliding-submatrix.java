class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length , n =grid[0].length ;
        int[][] ans  = new int[m-k+1][n-k+1];

        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                // find min abs for every idx
                int[] arr = new int[k*k];
                int idx=0;
                for(int r=i;r<i+k;r++){
                    for(int c=j;c<j+k;c++){
                        arr[idx++] = grid[r][c];
                    }
                }

                Arrays.sort(arr);

                int min = Integer.MAX_VALUE;
                for(int x=1;x<arr.length;x++){
                    if(arr[x]==arr[x-1]) continue;
                    min =Math.min(min,arr[x]-arr[x-1]);
                }

                if(min==Integer.MAX_VALUE) min =0;

                ans[i][j] = min;
            }
        }

        return ans;
    }
}

/*
[1,-2,3]
[2,3 ,5]
[4,3,10]

[1,2]
[1,2]

*/