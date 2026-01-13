class Solution {
    public double separateSquares(int[][] square) {
        int n= square.length;
    
        double total =0;
        double miny= Integer.MAX_VALUE;
        double maxy =-1;
        for(int i=0;i<n;i++){
            total+= Math.pow(square[i][2],2);
            miny=Math.min(miny,square[i][1]);
            maxy=Math.max(maxy,square[i][1]+square[i][2]);
        }

        double s=miny ,e=maxy;
   
        for (int i = 0; i < 100; i++) {
            double mid = s + (e - s) / 2.0;
            if (ispossible(square, mid) < total / 2.0) {
                s = mid;
            } else {
                e = mid;
            }
        }

        return s;
    }

    private double ispossible(int[][] square, double ymax) {
        double area = 0;
        for (int[] s : square) {
            double yi = s[1];
            double li = s[2];
            double top = yi + li;

            if (top <= ymax) {
                area += li * li;
            } else if (yi < ymax) {
                area += li * (ymax - yi);
            }
          
        }
        return area;
    }
}