class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n= neededTime.length;
        int cost=0;
        int prev=0;
        for(int i=1;i<n;i++){
            if(colors.charAt(i)==colors.charAt(prev)){
                if(neededTime[i]>neededTime[prev]) {
                    cost+=neededTime[prev];
                    prev=i;
                }
                else{
                    cost+=neededTime[i];
                }
            }
            else prev=i;
        }
        return cost;
    }
}