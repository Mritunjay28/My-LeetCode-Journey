class Solution {
    public int climbStairs(int n) {
        int[] step = new int[n+1];
        step[1]=1;
        if(n>=2) step[2]=2;
        for(int i=3;i<=n;i++) step[i]+=step[i-1]+step[i-2];

        return step[n];
    }
}