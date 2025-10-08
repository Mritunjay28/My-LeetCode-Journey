class Solution {

     private boolean bfs(int effort ,int[][] height,boolean[][] visited ){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        visited[0][0]=true;

        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col  =curr[1];
            

            if(row==height.length-1 && col==height[0].length-1) return true;

            for(int[] dir : direction){
                int x= row+dir[0];
                int y= col+dir[1];

                if(x>=0 && x<height.length && y>=0 && y<height[0].length && !visited[x][y]){
                    int diff = Math.abs(height[x][y] - height[row][col]);
                    if(diff <= effort){
                        q.offer(new int[] {x,y});
                        visited[x][y]=true;
                    } 
                }
            }

           
        }

        return false;
    }

    public int minimumEffortPath(int[][] height) {
        int s=0,e=999999,ans=0;
        while(s<=e){
            int mid = s+(e-s)/2;
            boolean[][] visited = new boolean[height.length][height[0].length];
            if(bfs(mid,height,visited)){
                ans=mid;
                e=mid-1;
            }
            else s= mid+1;
        }
        return ans;
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

*/