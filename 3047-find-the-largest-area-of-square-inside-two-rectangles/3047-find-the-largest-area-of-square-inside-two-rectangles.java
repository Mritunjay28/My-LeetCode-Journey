class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {


        int side=0;
        int n= bottomLeft.length;
        for(int i=0;i<n;i++){
            int b1x = bottomLeft[i][0];
            int b1y = bottomLeft[i][1];
            int t1x = topRight[i][0];
            int t1y = topRight[i][1];

            for(int j=0;j<n;j++){
                if(j==i) continue;
                int b2x = bottomLeft[j][0];
                int b2y = bottomLeft[j][1];
                int t2x = topRight[j][0];
                int t2y = topRight[j][1];

                int minx = Math.max(b1x,b2x);
                int miny = Math.max(b1y,b2y);
                int maxx = Math.min(t1x,t2x);
                int maxy = Math.min(t1y,t2y);
              

                if(minx<maxx && miny<maxy){
                    int min = Math.min(maxx-minx, maxy-miny);
                    side=Math.max(side,min);
                }
            }
        }

        return (long)side*(long)side;
    }
}