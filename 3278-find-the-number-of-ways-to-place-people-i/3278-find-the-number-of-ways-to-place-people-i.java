class Solution {
    public int numberOfPairs(int[][] points) {
         Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); 
            }
            return Integer.compare(a[0], b[0]);
        });
        int count=0;
        for(int i=0;i<points.length;i++){
              int Ay = points[i][1];
              int maxY = Integer.MIN_VALUE;
            for(int j=i+1;j<points.length;j++){
                int By = points[j][1];
                if(Ay>=By && By > maxY) {
                     count++;
                     maxY = By;
                }
            }
        }

        return count;
    }
}