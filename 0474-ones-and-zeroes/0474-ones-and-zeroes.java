class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //   return f(0,strs,m,n);
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];

        for (int i = l - 1; i >= 0; i--) {
            for (int x = 0; x <= m; x++) {
                for (int y = 0; y <= n; y++) {
                    int zero = 0, one = 0;
                    for (int j = 0; j < strs[i].length(); j++) {
                        if (strs[i].charAt(j) == '0')
                            zero++;
                        else
                            one++;
                    }

                    int take = 0;
                    if (zero <= x && one <= y) {
                        take = 1 + dp[i + 1][x - zero][y - one];
                    }

                    int nottake = dp[i + 1][x][y];

                    dp[i][x][y] = Math.max(take, nottake);
                }
            }
        }

        return dp[0][m][n];

    }

    // public int f(int i,String[] strs, int m, int n){
    //     if(i==strs.length ) return 0;        

    // int zero=0,one=0;
    // for(int j=0;j<strs[i].length();j++) {
    //     if(strs[i].charAt(j)=='0') zero++;
    //     else one++;
    // }

    // int take =0;
    // if (zero <= m && one <= n) {
    //     take = 1 + f(i + 1, strs, m - zero, n - one);
    // }

    // int nottake = f(i+1,strs,m,n);

    // return Math.max(take,nottake);
    // }
}