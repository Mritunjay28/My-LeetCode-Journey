class Solution {
    int mod = 1_000_000_007;
    int[][] memo;

    public int countPartitions(int[] nums, int k) {
        long sum = 0;
        for (int x : nums) sum += x;

        if (sum < 2 * (long) k) return 0;

        //return f(0,nums,k,sum,0);

        memo = new int[nums.length][k];
        for (int[] row : memo) Arrays.fill(row, -1);

        long invalid = flip(0, nums, k, 0);
        long total = 1;
        for (int i = 0; i < nums.length; i++){
            total = (total*2)%mod;
        }
            
        long ans = (total - 2L*invalid) % mod;
        return (int) ((ans+mod)%mod);
    }

    // public int f(int i, int[] nums, int k, long sum,long currsum){
    //     if(currsum>=k && sum-currsum <k) return 0;
    //     if(i==nums.length && currsum>=k && sum-currsum >=k) return 1;
    //     if(i==nums.length) return 0;

    //     int count=0;
    //     // take
    //     count+= f(i+1,nums,k,sum,currsum+nums[i]);

    //     // nottake
    //     count+= f(i+1,nums,k,sum,currsum);

    //     return count;
    // }

    public int flip(int i, int[] nums, int k, int currsum) {
        if (i == nums.length) return 1;
        if(memo[i][currsum]!=-1) return memo[i][currsum];
       
        // nottake
        long count = flip(i + 1, nums, k, currsum);
        // take
        if (currsum + nums[i] < k)
            count += flip(i + 1, nums, k, currsum + nums[i]);
        return memo[i][currsum] = (int)(count%mod);
    }

    /*
    so my code was not able to memo as currsum can be 10^9 * 10^3
    so to solve this we flip the question that 
    valid no = total - invalid subset 
    
    so for total ways we know it 2^n 
    for invalid we have to find subset that that have<k value so currsum will not exceed k-1 
     */
}
/*
to take care of 2 order set we whose sum >=k by using total sum - sum of current set, by this 2nd set is finded 

so we just have to find find distinct subset we can from nums that have value >=k with total - currsum >=k 

so minimum condition is that total sum of array must be >=2k then only we can give answer .

to form subset will use take or nottake 
*/