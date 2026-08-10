class Solution {
    private int MOD = 1_000_000_007;
    private Integer[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        dp = new Integer[len + 1][n + 1][minProfit + 1];
        return f(0, n,  minProfit, group, profit);
    }

    public int f(int i ,int n, int min, int[] group, int[] profit){
        if(n<0)  return 0;

        if(i==group.length ){
            return min <= 0 ? 1 : 0;
        }

        min = Math.max(0, min);
        if (dp[i][n][min] != null) return dp[i][n][min];

        // take 
        int take =0;
        take = f(i+1,n-group[i],min-profit[i],group,profit);

        // nottake 
        int nottake = f(i+1,n,min,group,profit);

        return dp[i][n][min] = (take + nottake)%MOD;
    }
}