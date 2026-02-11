class Solution {
    public int closedIsland(int[][] grid) {
        int n =grid.length , m= grid[0].length ; 
        List<int[]> location = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) location.add(new int[] {i,j});
            }
        }

        int count=0;

        for(int i=0;i<location.size();i++){
            int[] temp = location.get(i);
            int x = temp[0] , y = temp[1];
            if(!visited[x][y]) {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{x,y});
                boolean allNotAtEdge = false;
                int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
                while(!q.isEmpty()){
                    int[] temp2 = q.poll();
                    int x_=temp2[0] ,y_=temp2[1];
                    if((x_==0 || x_==n-1) || (y_==0 || y_==m-1)) allNotAtEdge=true;

                    for(int[] d : dir){
                        int r = x_+d[0] , c =y_+d[1];
                        
                        if(r>=0 && r<n && c>=0 && c<m && !visited[r][c] && grid[r][c]==0) {
                            q.add(new int[] {r,c});
                        }
                        else if(r<0 && r>=n && c<0 && c>=m) allNotAtEdge=true;
                    }

                    visited[x_][y_]=true;
                }

                if(!allNotAtEdge) count++;  
            }
        }
        return count;
    }
}