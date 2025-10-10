class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length , n=isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1) q.offer(new int[] {i,j});
            }
        }

        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int[] curr =q.poll();
                int row= curr[0] , col = curr[1];
                for(int[] dir :direction){
                    int x = row+dir[0] , y= col+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && isWater[x][y]==0){
                        height[x][y]= height[row][col]+1;
                        isWater[x][y]=1;
                        q.offer(new int[] {x,y});
                    }
                }
            }
        }

        return height;
    }
}