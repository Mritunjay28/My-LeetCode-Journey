class Solution {
    public int largestAltitude(int[] gain) {
        int max =0;
        int point =0;
        for(int x :gain){
            point+=x;
            max=Math.max(max,point);
        }

        return max;
    }
}