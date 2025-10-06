class Solution {
    int[][] direction = {{0,1},{1,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n==0 || grid[0][0]==1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        grid[0][0]=1;

        int level=0;

        while(!q.isEmpty()){
            int len=q.size();
            while(len-->0){
                int[] curr =q.poll();
                int x=curr[0],y=curr[1];
                if(x==n-1 && y==n-1) return level+1;
                for(int[] dir : direction){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];
                    if(x_>=0 && x_<n && y_>=0 && y_<n && grid[x_][y_]==0 ){
                        q.offer(new int[] {x_,y_});
                        grid[x_][y_]=1;
                    }
                }
            }
            level++;
        }

        return -1;

    }
}