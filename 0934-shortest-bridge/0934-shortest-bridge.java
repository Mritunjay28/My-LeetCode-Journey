class Solution {
     int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        boolean first =false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    dfs(i,j,grid,visited,q);
                    first=true;
                    break;
                }  
            }
            if(first) break;
        }

        int level =0;
        while(!q.isEmpty()){
            int l = q.size();
            for(int k=0;k<l;k++){
                int[] curr = q.poll();
                int i = curr[0] , j= curr[1];

                for(int[] d : dir ){
                    int x = i+d[0] , y=j+d[1];
                    if(x>=0 && x<n && y>=0 && y<n ){
                        if(grid[x][y]==0 && !visited[x][y]) {
                            q.add(new int[] {x,y});
                            visited[x][y] = true;
                        }
                        else if(grid[x][y]==1 && !visited[x][y]){
                            return level;
                        }
                    }

                }
            }

            level++;
        }
        return -1;

    }
   
    public void dfs(int i,int j,int[][] grid,boolean[][] visited, Queue<int[]> q){
        int n = grid.length;
        visited[i][j]=true;
        boolean iszero = false;

        for(int[] d : dir){
            int x = i+d[0] , y = j+d[1];

            if(x>=0 && x<n && y>=0 && y<n){
                if(grid[x][y]==0) iszero=true;
                else if(grid[x][y]==1 && !visited[x][y]) dfs(x,y,grid,visited,q);
            }
        }

        if(iszero) q.add(new int[] {i,j});
    }
}

/*
[1,1,1,1,1]
[1,0,0,0,1]
[1,0,1,0,1]
[1,0,0,0,1]
[1,1,1,1,1]
*/