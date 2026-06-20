class Solution {
    public int maxBuilding(int n, int[][] res) {
        if (res.length == 0) {
            return n - 1;
        }
        int max = 0;
        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));

        // this part handle the cases when available < 0 
        // If a restriction array says Building 3 max height = 10 but Building 5 max height = 0, that 10 is a lie. Building 3 can never actually reach 10. The right-to-left pass corrects these "lies" .
        // this handle case like 4-8 and 6-5 then it will do 4-7 and 6-5
        for (int i = res.length - 2; i >= 0; i--) {
            int idDiff = res[i + 1][0] - res[i][0];
            res[i][1] = Math.min(res[i][1], res[i + 1][1] + idDiff);
        }
        // also cap the very first restriction against its distance from building 1
        res[0][1] = Math.min(res[0][1], res[0][0] - 1);

        int prev = 1, h = 0;
        for (int i = 0; i < res.length; i++) {
            int id = res[i][0], val = res[i][1];

            // this handle the case when 4-5 and 6-8 , then it select 4-5 and 6-7 as select min(8,5+(6-4)) = min(8,7)
            val = Math.min(val, h + (id - prev));

            int diff = id - prev;
            int valDiff = Math.abs(val - h);
            int available = diff - valDiff;

            int increase = (int) Math.floor((double) available / 2);
            int currmax = Math.max(h, val) + increase;
            max = Math.max(max, currmax);
            prev = id;
            h = val;

        }

        if (prev != n) {
            max = Math.max(max, h + (n - prev));
        }

        return max;
    }
}