class Solution {
    public long maxRatings(int[][] units) {
        long sum =0;
        int m =units.length;
        int n = units[0].length;
        if(n==1){
            for(int i=0;i<m;i++) sum+=units[i][0];
            return sum;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int[] row : units) {
            Arrays.sort(row);

            min1 = Math.min(min1, row[0]);
            min2 = Math.min(min2, row[1]);

            sum += row[1];
        }

        return sum - min2 + min1;
    }
}