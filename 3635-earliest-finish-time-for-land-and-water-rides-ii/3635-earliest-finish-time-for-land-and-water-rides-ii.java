class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans =Integer.MAX_VALUE;
        int minLand=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            minLand=Math.min(minLand,landStartTime[i]+landDuration[i]);
        }

        for(int i=0;i<waterStartTime.length;i++){
            if(minLand>=waterStartTime[i]){
                ans =Math.min(ans,minLand+waterDuration[i]);
            }else{
                ans =Math.min(ans,minLand+(waterStartTime[i]-minLand)+waterDuration[i]);
            }
        }

        int minWater=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            minWater=Math.min(minWater,waterStartTime[i]+waterDuration[i]);
        }

        for(int i=0;i<landStartTime.length;i++){
            if(minWater>=landStartTime[i]){
                ans =Math.min(ans,minWater+landDuration[i]);
            }else{
                ans =Math.min(ans,minWater+(landStartTime[i]-minWater)+landDuration[i]);
            }
        }

        return ans;
    }
}