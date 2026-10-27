class Solution {
    public String[] createGrid(int m, int n) {
        char[][] arr = new char[m][n];
        dfs(arr,0,0);
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(arr[i][j]=='.') sb.append('.');
                else sb.append('#');
            }
            ans[i]=sb.toString();
        }

        return ans;
    }

    public boolean dfs(char[][] arr,int i,int j){
        if(i==arr.length-1 && j==arr[0].length-1){
            arr[i][j]='.';
            return true;
        } 
        if(i>arr.length-1 || j>arr[0].length-1) return false;
        
        boolean right = dfs(arr,i,j+1);
        if(right) {
            arr[i][j]='.';
            return true;
        }
        boolean left = dfs(arr,i+1,j);
         if(left) {
            arr[i][j]='.';
            return true;
        }

        return false;
    }
}