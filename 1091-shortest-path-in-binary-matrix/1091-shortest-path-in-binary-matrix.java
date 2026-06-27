class Solution {
    int[][] direction = {{0,1},{1,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n==0 || grid[0][0]==1) return -1;

        // Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
    Arrays.fill(distance[i], Integer.MAX_VALUE);
}
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        q.offer(new int[] {0,0,0});
        grid[0][0]=1;
        distance[0][0]=0;

        while(!q.isEmpty()){
            int len=q.size();
            while(len-->0){
                int[] curr =q.poll();
                int currdistance=curr[0];
                int x=curr[1],y=curr[2];

                for(int[] dir : direction){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];
                    if(x_>=0 && x_<n && y_>=0 && y_<n && grid[x_][y_]==0 && currdistance+1<distance[x_][y_]){
                        q.offer(new int[] {currdistance+1,x_,y_});
                        grid[x_][y_]=1;
                        distance[x_][y_]=currdistance+1;
                    }
                }
            }
        }

        return (distance[n-1][n-1]==Integer.MAX_VALUE) ? -1 : distance[n-1][n-1]+1;

    }
}