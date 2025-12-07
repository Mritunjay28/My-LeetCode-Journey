class Solution {
    public int countOdds(int low, int high) {
        int count1=low/2;
        int count2 =high/2;
        if(high%2!=0) count2++;
        return count2-count1;
    }
}