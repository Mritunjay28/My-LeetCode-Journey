class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[] prefix = new int[n];
        int max =-1;
        for(int i=n-1;i>=0;i--){
            if(max>prices[i]) prefix[i]=max;
            max=Math.max(max,prices[i]);
        }

        for(int i=0;i<n;i++) System.out.print(prefix[i]+" ");

        max=0;
        for(int i=0;i<n;i++) max=Math.max(max,prefix[i]-prices[i]);

        return max;

    }
}