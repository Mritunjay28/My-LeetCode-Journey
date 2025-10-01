class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int candrink = numBottles, emptybottle=0,totaldrink = 0;
        while(candrink>0 || emptybottle>=numExchange){
            if(candrink>0) {
                totaldrink+=candrink;
                emptybottle += candrink;
                candrink=0;
            }
            else{
                candrink = (int)Math.floor((double) emptybottle/numExchange);
                emptybottle %= numExchange ;
            }
        }

        return totaldrink;
    }
}