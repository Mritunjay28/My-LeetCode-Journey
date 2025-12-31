class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int ans =-1;
        int s=0,e=row*col-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(ispossible(mid,cells,row,col)){
                ans=mid;
                s=mid+1;
            }
            else e=mid-1;
        }

        return ans+1; // 1 index we have to give answer 
    }

    boolean ispossible(int k,int[][] cells,int m,int n){
        int[][] mat = new int[m][n];

        for(int i=0;i<=k;i++) mat[cells[i][0]-1][cells[i][1]-1]=1;

        for(int i=0;i<n;i++){
            if(mat[0][i]!=1 && bfs(0,i,mat)) return true;
        }

        return false;
    }

    boolean bfs(int x , int y , int[][] mat){
        int m = mat.length, n = mat[0].length;
        boolean[][] arr = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(new int[] {x,y});
        arr[x][y]=true;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int i = temp[0] , j =temp[1];
            if(i==m-1) return true;
    
            if(j+1 <n && mat[i][j+1]!=1 && !arr[i][j+1]){
                q.add(new int[] {i,j+1});
                arr[i][j+1]=true;
            } 
            if(j-1 >=0 && mat[i][j-1]!=1 && !arr[i][j-1]){
                q.add(new int[] {i,j-1});
                arr[i][j-1]=true;
            } 
            if(i+1 <m && mat[i+1][j]!=1 && !arr[i+1][j]){
                q.add(new int[] {i+1,j});
                arr[i+1][j]=true;
            } 
            if(i-1 >=0 && mat[i-1][j]!=1 && !arr[i-1][j]){
                q.add(new int[] {i-1,j});
                arr[i-1][j]=true;
            } 
           
        }

        return false;
    }
}