class Solution {
    int max = 0;
    int[][] memo = new int[1001][1001];

    public int maxJumps(int[] arr, int d) {

        for (int i = 0; i < arr.length; i++) {
            dfs(i, arr, d, 1);
            if(max==arr.length) break;
        }
        return max;
    }

    public void dfs(int idx, int[] arr, int d, int count) {

        if(memo[idx][count]!=0) return ;

        for (int i = idx - 1; i >= Math.max(0, idx - d); i--) {
            if (arr[i] >= arr[idx]) break;
             dfs(i,arr,d,count+1);
        }

        // right
        for (int i = idx + 1; i <= Math.min(arr.length - 1, idx + d); i++) {
            if (arr[i] >= arr[idx]) break;
            dfs(i,arr,d,count+1);
        }


        max=Math.max(max,count);
        memo[idx][count]=max;
    }
}