class Solution {
    public int numEnclaves(int[][] grid) {
        int total =0;
        int n =grid.length , m=grid[0].length;
        List<int[]> location  =new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j]==1) location.add(new int[]{i,j});
                if(grid[i][j]==1) total++;
            }
        }

        int count=0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<location.size();i++){
            int[] temp =location.get(i);
            int x = temp[0] ,y=temp[1];
            if(!visited[x][y]){
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{x,y});
                 count++;
                  visited[x][y]=true;
                int[][] dir = {{0,1} , {1,0},{-1,0},{0,-1}};
                while(!q.isEmpty()){
                    int[] temp2 = q.poll();
                    int x_ =temp2[0] , y_ = temp2[1];
                   

                    for(int[] d : dir){
                        int r= x_+d[0] , c =y_+d[1];
                        if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==1 && !visited[r][c]){
                            q.add(new int[] {r,c});
                             visited[r][c]=true;
                            count++;
                        } 
                    }

                    
                   
                }
            }
           
        }

        return total-count;
    }
}