class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        for(int x : costs) {
            if(x>coins) break;
            count++;
            coins-=x;
        }

       return count; 
    }
}