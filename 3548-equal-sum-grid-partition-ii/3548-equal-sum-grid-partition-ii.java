class Solution {
    public boolean canPartitionGrid(int[][] g) {
        int m = g.length , n =g[0].length;
        long[][] pref = new long[m][n];
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        long sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum+=g[i][j];
                if(i==0 && j==0) pref[i][j] = g[i][j];
                else if (i==0) pref[i][j] = g[i][j]+ pref[i][j-1];
                else if (j==0) pref[i][j] = g[i][j] +pref[i-1][j];
                else{
                    pref[i][j] = g[i][j] + (pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1] ); 
                } 

                int val = g[i][j];
                int flatidx = (i * n) + j; // Logic to flatten 2D to 1D
                indexMap.computeIfAbsent(val, k -> new ArrayList<>()).add(flatidx);
            }
        }

       
       // horizontal
        if (n - 1 >= 0) {
            for (int i = 0; i < m - 1; i++) {
                long topSum = pref[i][n - 1];
                long bottomSum = sum - topSum;

                if (topSum == bottomSum) return true;

                if (topSum > bottomSum) {
                    // top needs to drop a value to equal bottom
                    long target = topSum - bottomSum;
                    if (target > 0 && target <= Integer.MAX_VALUE && indexMap.containsKey((int) target)) {
                        if (i == 0 || n == 1) { // Top is 1 row, can only remove corners to stay connected
                            if (g[0][0] == target || g[i][n - 1] == target) return true;
                        } else {      // >1 row, any cell in top section works
                            if (indexMap.get((int) target).get(0) <= i * n + n - 1) return true;
                        }
                    }
                } else {
                    // bottom needs to drop a value to equal top
                    long target = bottomSum - topSum;
                    if (target > 0 && target <= Integer.MAX_VALUE && indexMap.containsKey((int) target)) {
                        if (i == m - 2 || n == 1) { // Bottom is 1 row, can only remove corners
                            if (g[i+1][0] == target || g[m - 1][n - 1] == target) return true;
                        } else {          // >1 row, any cell in bottom section works
                            List<Integer> list = indexMap.get((int) target);
                            if (list.get(list.size() - 1) >= (i + 1) * n) return true;
                        }
                    }
                }
            }
        }

        // vertical
        if (m - 1 >= 0) {
            for (int j = 0; j < n - 1; j++) { 
                long leftSum = pref[m - 1][j];
                long rightSum = sum - leftSum;

                if (leftSum == rightSum) return true;

                if (leftSum > rightSum) {
                    // left needs to drop
                    long target = leftSum - rightSum;
                    if (target > 0 && target <= Integer.MAX_VALUE && indexMap.containsKey((int) target)) {
                        if (j == 0 || m == 1) { // Left is 1 col
                            if (g[0][0] == target || g[m - 1][j] == target) return true;
                        } else {      // >1 col, check map if target exists in left columns
                            for (int idx : indexMap.get((int) target)) {
                                if (idx % n <= j) return true;
                            }
                        }
                    }
                } else {
                    // right needs to drop
                    long target = rightSum - leftSum;
                    if (target > 0 && target <= Integer.MAX_VALUE && indexMap.containsKey((int) target)) {
                        if (j == n - 2 || m == 1) { // Right is 1 col
                            if (g[0][j + 1] == target || g[m - 1][n - 1] == target) return true;
                        } else {          // >1 col, check map if target exists in right columns
                            for (int idx : indexMap.get((int) target)) {
                                if (idx % n > j) return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}