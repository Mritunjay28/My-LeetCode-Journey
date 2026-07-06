class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
           Arrays.sort(intervals, (a, b) ->  a[0] - b[0] );
        int max=0,left=-1,right=-1;
        for(int[] val : intervals){
            if(val[0]>left && right < val[1]){
                max++;
                left=val[0];
            }
            right=Math.max(right,val[1]);
        }
        return max;
    }
}