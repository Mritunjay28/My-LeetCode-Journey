class Solution {
    int m;
    int n;
    public int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        for (int j = 0; j < n; j++) f(0,j,mat);
        for (int i = 1; i < m; i++) f(i,0,mat);

        return mat;
    }

    public void f(int i, int j, int[][] mat) {
        List<Integer> list = new ArrayList<>();
        int r = i, c = j;
        while (r < m && c < n) {
            list.add(mat[r][c]);
            r++;
            c++;
        }

        Collections.sort(list);

        r = i;
        c = j;
        int k = 0;

        while (r < m && c < n) {
            mat[r][c] = list.get(k++);
            r++;
            c++;
        }
    }

}