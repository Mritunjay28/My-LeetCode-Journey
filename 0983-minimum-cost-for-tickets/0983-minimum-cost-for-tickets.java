class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.sort(days);
 //        return f(0,0,days,costs);
        int n = days.length;
        int[][] dp = new int[n + 1][days[n - 1] + 31];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = days[n - 1]; j >= 0; j--) {
                int passexist = (int) 1e9;
                if (j >= days[i]) {
                    passexist = dp[i+1][j];
                }
                int cost1 = costs[0] + dp[i+1][days[i]];
                int cost7 = costs[1] + dp[i+1][days[i]+6]; 
                int cost30 = costs[2] +dp[i+1][days[i]+29];  

                dp[i][j] =  Math.min(passexist, Math.min(cost1, Math.min(cost7, cost30)));
            }
        }

        return dp[0][0];
    }

    // public int f(int i,int day,int[] days, int[] costs){
    //     if(i==days.length) return 0;

    // int passexist = (int) 1e9;
    // if(day>=days[i]){
    //     passexist = f(i+1,day,days,costs);
    // }
    // int cost1= costs[0]+f(i+1,day+1,days,costs);
    // int cost7= costs[1]+f(i+1,day+7,days,costs);
    // int cost30= costs[2]+f(i+1,day+30,days,costs);

    // return Math.min(passexist,Math.min(cost1,Math.min(cost7,cost30)));
    // }
}