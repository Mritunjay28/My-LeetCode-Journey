class Solution {

     private void dijkastra(int[][] height,int[][] result){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        q.offer(new int[] {0,0,0});

        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty()){ 
            int[] curr = q.poll(); 
            int row = curr[0];
            int col  =curr[1];
            int distance = curr[2];

            // if(row==height.length-1 && col==height[0].length-1) return true;

            for(int[] dir : direction){
                int x= row+dir[0];
                int y= col+dir[1];

                if(x>=0 && x<height.length && y>=0 && y<height[0].length ){
                   int newEffort = Math.max(distance, Math.abs(height[x][y] - height[row][col]));
                    if (newEffort < result[x][y]) {
                        result[x][y] = newEffort;
                        q.offer(new int[]{ x, y,newEffort});
                    }
                }
            }
        }
    }

    public int minimumEffortPath(int[][] height) {
        int[][] result = new int[height.length][height[0].length];

        for (int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);
        
        result[0][0] = 0;
        dijkastra(height,result);
        return result[height.length-1][height[0].length-1];
    }
   
}

/* 
minimize the max absolute difference for this think of binary search to apply on what(effort)
minimum effort 0 (whole path same value)
maximum effort  1-10^6 so max effort = 1000000-1 = 999999 // can be max- min of array 

now how to check paths ? 
we can move in 4 direction we will move to next path on when less or equal  to effort given 
we will use bfs start 0,0 and when we will get n-1,m-1 we will return that true
will mark each cell we visit by -1 to not return 

T.C = logn

*/