class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length , n =grid[0].length ;
        int[][] ans  = new int[m-k+1][n-k+1];

        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                // find min abs for every idx
                List<Integer> arr = new ArrayList<>();
                for(int r=i;r<i+k;r++){
                    for(int c=j;c<j+k;c++){
                        arr.add(grid[r][c]);
                    }
                }

                Collections.sort(arr);

                int min = Integer.MAX_VALUE;
                for(int x=1;x<arr.size();x++){
                    if(arr.get(x).equals(arr.get(x-1))) continue;
                    min =Math.min(min,Math.abs(arr.get(x)-arr.get(x-1)));
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