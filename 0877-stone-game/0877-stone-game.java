class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];
      
        return f(0,n-1,piles,memo) >0;
    }

    public int f(int i,int j,int[] piles, Integer[][] memo){
        if(i==j) return piles[i];

        if(memo[i][j]!=null) return memo[i][j];

        int first = piles[i] - f(i+1,j,piles,memo);
        int last = piles[j] - f(i,j-1,piles,memo);

        return memo[i][j] = Math.max(first,last);
    }
}