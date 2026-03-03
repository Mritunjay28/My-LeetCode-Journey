class Solution {
    public int orangesRotting(int[][] grid) {
        int m= grid.length,n=grid[0].length;

        int t=0;
        Queue<int[]> q = new LinkedList<>();
        int freshcount=0;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.offer(new int[] {i,j});
                if(grid[i][j]==1)  freshcount++;
            }
        }

        if(freshcount==0) return 0;

        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] curr = q.poll();
                int row=curr[0],col=curr[1];
                for(int[] dir : direction){
                    int x =row+dir[0] , y= col+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        q.offer(new int[] {x,y});
                        grid[x][y]=2;
                       freshcount--;
                    }
                }
            }
            t++;
        }

        return (freshcount==0) ? t-1 : -1;
    }
}