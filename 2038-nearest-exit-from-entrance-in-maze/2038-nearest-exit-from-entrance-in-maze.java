class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length , n= maze[0].length;
        // List<List<int[]>> adj = new ArrayList<>();
        // for(int i=0;i<)
        boolean[][] visited =  new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        visited[entrance[0]][entrance[1]]=true;
        int level=0;

        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int len=q.size();
            while(len-- > 0){
            int[] curr =q.poll();
            int row= curr[0],col=curr[1];
            if((row==m-1 || col==n-1 || row==0 || col==0) && !(row == entrance[0] && col == entrance[1])) return level;
            for(int[] dir : direction){
                int x =row+dir[0],y= col+dir[1];
                if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && maze[x][y]=='.'){
                    q.offer( new int[] {x,y});
                    visited[x][y]=true;
                }
            }
            }
            level++;
        }

        return -1;

    }
}