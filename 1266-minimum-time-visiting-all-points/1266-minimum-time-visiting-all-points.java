class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x=points[0][0] , y =points[0][1];
        int step=0;
        for(int i=1;i<points.length;i++){
            int x_ = points[i][0] , y_ = points[i][1];

            int xdistance = Math.abs(x_ - x);
            int ydistance = Math.abs(y_ - y);

            int common = Math.min(xdistance,ydistance);
            xdistance-=common;
            ydistance-=common;

            step+=common;

            if(xdistance>0) step+=xdistance;
            if(ydistance>0) step+=ydistance;

            x=x_;
            y=y_;
        }

        return step;
    }
}
// tke diagonal as many time as possible then take either rmaining x and y distance;