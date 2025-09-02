class Solution {
    public int numberOfPairs(int[][] points) {
        int count=0;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                int Ax=points[i][0] , Ay = points[i][1];
                int Bx=points[j][0] , By = points[j][1];

                if(Ax>=Bx && Ay<=By) {
                    boolean update=true;
                    for(int k=0;k<points.length ; k++){
                       if(k==i || k==j) continue;
                       int x =points[k][0] , y= points[k][1];
                       if (Bx <= x && x <= Ax && By >= y && y >= Ay) {
                            update =false;
                            break;
                        }
                    }
                    if(update) count++;
                }
            }
        }

        return count;
    }
}