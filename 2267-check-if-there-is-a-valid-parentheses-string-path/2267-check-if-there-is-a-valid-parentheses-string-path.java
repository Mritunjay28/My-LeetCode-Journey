class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m= grid.length;
        int n = grid[0].length;

        if(grid[0][0]==')') return false;
        if(grid[m-1][n-1]=='(') return false;
        if ((m + n - 1) % 2 != 0) return false;


        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][m + n];

        q.add(new int[] {0,0,1});
        visited[0][0][1]=true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i=curr[0];
            int j=curr[1];
            int count=curr[2];
            

            if(i==m-1 && j==n-1){
                if(count==0) return true;
                else continue;
            } 

            // right;
            int x = i;
            int y= j+1;
            if(x<m && y<n){
                int temp=count;
                if(grid[x][y]=='(') temp++;
                else temp--;
                if(temp>=0 && !visited[x][y][temp]){
                    q.add(new int[] {x,y,temp});
                    visited[x][y][temp] = true;
                }
            }
            // down
            x = i+1;
            y= j;
            if(x<m && y<n){
                if(grid[x][y]=='(') count++;
                else count--;
                if(count>=0 && !visited[x][y][count]){
                    q.add(new int[] {x,y,count});
                    visited[x][y][count] = true;
                }
            }
        }

        return false;
    }
}