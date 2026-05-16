class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dis = new int[mat.length][mat[0].length];
        boolean flag = true;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0) {
                    q.offer(new int[] {i,j});
                    dis[i][j]=0;
                }
                else {
                    dis[i][j]=-1;
                    flag=false;
                    }
            }
        }

        if(flag) return dis;

        int l = 1;
        // now do bfs for queue 
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int[] temp = q.poll();

                int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

                for(int[] d : dir){
                    int x = temp[0]+d[0] , y=temp[1]+d[1];

                    if(x>=0 && x<mat.length && y>=0 && y<mat[0].length && dis[x][y]==-1){
                        dis[x][y]=l;
                        q.offer(new int[] {x,y});
                    } 
                }
            }
            l++;
        }

        return dis;
        
    }
}