class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;
        if (n == 0) return 0;

        int[] leftProfit = new int[n]; // maxprofit if sell today or before today
        int[] rightProfit = new int[n]; // maxprofit if buy today or after today

        int minprice=prices[0];
        for(int i=1;i<n;i++){
            minprice=Math.min(minprice,prices[i]);
            leftProfit[i] = Math.max(leftProfit[i-1],prices[i]-minprice);
        } 

        int maxprice=prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxprice=Math.max(maxprice,prices[i]);
            rightProfit[i] = Math.max(rightProfit[i+1],maxprice-prices[i]);
        } 

        int maxprofit=0;
        for(int i=0;i<n;i++){
            maxprofit=Math.max(maxprofit,leftProfit[i]+rightProfit[i]);
        }

        return maxprofit;

    }
}