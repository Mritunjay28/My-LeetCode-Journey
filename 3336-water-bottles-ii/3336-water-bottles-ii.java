class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total=0;
     int empty=0,available=numBottles;

     while(available>0 || empty >=numExchange){
        if(available>0) {
            total+=available;
            empty+=available;
            available=0;
        }
        else{
            empty-=numExchange;
            numExchange++;
            available++;
        }
     }

     return total;
    }
}