class Solution {
    public int numSquares(int n) {
        List<Integer> set = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            set.add(i * i);
        // return  f(0,set,n);
        int l = set.size();
        int[][] dp = new int[l + 1][n + 1];

        for (int i = 1; i <= n; i++)
            dp[l][i] = (int) 1e9;

        for (int i = l - 1; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {

                // take 
                int take = (int) 1e9;
                if (set.get(i) <= j)
                    take = 1 + dp[i][j-set.get(i)];
                // nottake
                int nottake = dp[i+1][j]; 

                dp[i][j] = Math.min(take, nottake);
            }
        }

        return dp[0][n];
    }

    // public int f(int i,List<Integer> set,int n){
    //     if(n==0) return 0;
    //     if(i==set.size()) return (int)1e9;

    // // take 
    // int take =(int)1e9;
    // if(set.get(i) <= n) take = 1+f(i,set,n-set.get(i));
    // // nottake
    // int nottake = f(i+1,set,n);

    // return Math.min(take,nottake);
    // }
}