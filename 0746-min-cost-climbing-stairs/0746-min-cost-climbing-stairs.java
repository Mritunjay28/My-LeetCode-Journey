class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;

        int[] arr = new int [n];
        arr[0] = cost[0];
        arr[1] = cost[1];

        if(n==2) return Math.min(arr[0],arr[1]);
        
        for(int i=2;i<n;i++){
            arr[i] = Math.min(arr[i-2]+cost[i],arr[i-1]+cost[i]);
        }

        return Math.min(arr[n-1],arr[n-2]);
    }
}