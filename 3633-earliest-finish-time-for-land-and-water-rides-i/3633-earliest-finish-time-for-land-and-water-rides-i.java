class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        // min time if first go to landride then waterride 
        int minLandTime =10001;
        for(int i=0;i<n;i++) minLandTime=Math.min(minLandTime,landStartTime[i]+landDuration[i]);

        // now try to find waterride which take minimum time after water ride 
        int t1 = 100001;
        for(int i=0;i<m;i++){
            if(waterStartTime[i]<=minLandTime){
                t1=Math.min(t1,minLandTime+waterDuration[i]);
            }
            else {
                t1=Math.min(t1,waterStartTime[i]+waterDuration[i]);
            }
        }


        // min time if first go to waterride then landride 
        int minWaterTime =10001;
        for(int i=0;i<m;i++) minWaterTime=Math.min(minWaterTime,waterStartTime[i]+waterDuration[i]);

        // now try to find waterride which take minimum time after water ride 
        int t2 = 100001;
        for(int i=0;i<n;i++){
            if(landStartTime[i]<=minWaterTime){
                t2=Math.min(t2,minWaterTime+landDuration[i]);
            }
            else {
                t2=Math.min(t2,landStartTime[i]+landDuration[i]);
            }
        }

        return Math.min(t1,t2);
    }
}