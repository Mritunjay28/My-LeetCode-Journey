class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean isZeroPresent = false;
        for(int x:arr) if(x==0){
            isZeroPresent=true;
            break;
        }

        if(!isZeroPresent) return false;
        boolean[] visited = new boolean[arr.length];

        return dfs(arr,start,visited);
    }

    public boolean dfs(int[] arr, int i,boolean[] visited){
        if(arr[i]==0) return true;
        if(visited[i]) return false;
        visited[i]=true;
        boolean istrue=false;

        if(i-arr[i]>=0) istrue|= dfs(arr,i-arr[i],visited);
        if(istrue) return true;
        if(i+arr[i]<arr.length) istrue|= dfs(arr,i+arr[i],visited);

        return istrue;
    }
}