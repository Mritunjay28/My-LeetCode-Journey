class Solution {
    public int orangesRotting(int[][] grid) {
        int m= grid.length,n=grid[0].length;
        //System.out.println(m+"---"+n);
        if(m==1 && n==1){
            if(grid[0][0]==1) return -1;
            else return 0;
        }
        int t=0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited  =new boolean[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[] {i,j});
                    visited[i][j]=true;
                } 
               // if(grid[i][j]==0)  visited[i][j]=true;
            }
        }

        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] curr = q.poll();
                int row=curr[0],col=curr[1];
                for(int[] dir : direction){
                    int x =row+dir[0] , y= col+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && !visited[x][y]){
                        if(grid[x][y]==0)  visited[x][y]=true;
                        else{
                            q.offer(new int[] {x,y});
                            visited[x][y]=true;
                        }
                    }
                }
            }
            t++;
        }

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]) return -1;
            }
        }


       return t-1;
    }
}