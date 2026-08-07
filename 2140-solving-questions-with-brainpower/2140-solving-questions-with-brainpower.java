class Solution {
    public long mostPoints(int[][] arr) {
    //   return f(arr,0);

       long[] dp = new  long[arr.length+1]; // max points to get from i to n-1

       // base case 
       dp[arr.length]=0;

        for(int i=arr.length-1;i>=0;i--){ // backward direction 
        //transition 
            // take 
            long take = arr[i][0] ;
            if(i+1+arr[i][1] <=arr.length) take  += dp[i+1+arr[i][1]];

            // not take 
            long nottake = dp[i+1];

            dp[i] = Math.max(take,nottake);
        }

        return dp[0];
    }

    // public long f(int[][] arr,int i){
    //     if(i >= arr.length) return 0;
    //     // take
    //     long take = arr[i][0] + f(arr,i+1+arr[i][1]);

    //     // nottake
    //     long nottake = f(arr,i+1);

    //     return Math.max(take,nottake);
    // }
}