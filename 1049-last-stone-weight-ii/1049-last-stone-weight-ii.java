class Solution {
     int[][] dp; 
    public int lastStoneWeightII(int[] stones) {
       dp = new int[stones.length][3001];
       for(int[] d :dp) Arrays.fill(d,-1);
        return f(0,stones,0);
    }

    public int f(int i,int[] stones,int weight ){
        if(i==stones.length) return Math.abs(weight);
        if(dp[i][Math.abs(weight)]!=-1) return dp[i][Math.abs(weight)];
        int take = f(i+1,stones,weight+stones[i]);
        int nottake = f(i+1,stones,weight-stones[i]);

        return dp[i][Math.abs(weight)]=Math.min(take,nottake);
    }
}

/*
given that if(x<=y) we get y-x
thne if we smash it to z thne it like z-y+x

so basically assigning +ve ,-ve value to values , so to minimize smallest wait try to foem subset with sum/;
for 0;


*/