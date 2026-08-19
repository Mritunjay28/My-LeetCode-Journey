class Solution {
    public int maxProfit(int[] prices) {
        int[] maxprice = new int[prices.length];
        maxprice[prices.length-1]=-1;
        int max = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
         if(max>=prices[i]) maxprice[i]=max;
         else maxprice[i]=-1;
         max=Math.max(max,prices[i]);
        }

        int diff=0;
        for(int i=0;i<prices.length-1;i++){
            diff= Math.max(diff,maxprice[i]-prices[i]);
        }

        return diff;
    }
}