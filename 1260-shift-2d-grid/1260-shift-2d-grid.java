class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n =grid.length;
        int m =grid[0].length;

        int[][] temp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int no = n*m;

                k = k%no;

                int div = k/m;
                int rem = k%m;

                int row = i+div;
                int col = j+rem;

                if(row >=n) row = row % n;
                if(col >=m) {
                    row++;
                    row = row % n;
                    col = col % m;
                    }

                temp[row][col] = grid[i][j];
            }
        }

        for(int i=0;i<n;i++) ans.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               ans.get(i).add(temp[i][j]);
            }
        }

        return ans;
    }
}