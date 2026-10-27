class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        List<int[]> arr = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] >0) arr.add(new int[] {i,j});
            }
        }

        int count=0;

        int[][] dir ={{0,1},{1,0},{-1,0},{0,-1}};
        for(int l=0;l<arr.size();l++){
            int[] temp = arr.get(l);
            int i = temp[0],j=temp[1];
            if(visited[i][j]) continue;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {i,j});
            visited[i][j] = true;
            long sum=0;
            while(!q.isEmpty()){
                int[] curr = q.poll();
                i=curr[0];
                j=curr[1];
                sum+=grid[i][j];

                for(int[] d : dir){
                    int x = i+d[0];
                    int y = j+d[1];

                    if(x>=0 && x<n && y>=0 && y<m && grid[x][y]>0 && !visited[x][y]){
                        q.add(new int[] {x,y});
                        visited[x][y]=true;
                    }
                }
            }

            if(sum%k==0) count++; 
        }

        return count;
    }
}