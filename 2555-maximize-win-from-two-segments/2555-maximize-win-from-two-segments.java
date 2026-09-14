class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
    int n = prizePositions.length;
        
        // dp[i] stores the maximum number of prizes we can collect 
        // with a single segment in the prefix prizePositions[0...i-1].
        int[] dp = new int[n + 1];
        int maxPrizes = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Shrink the window until it fits within the allowed segment length k
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            
            // Prizes in the current valid segment ending at 'right'
            int currentSegmentPrizes = right - left + 1;
            
            // maxPrizes is the max of our current best, or the current valid segment 
            // PLUS the best single segment that comes strictly before 'left'
            maxPrizes = Math.max(maxPrizes, currentSegmentPrizes + dp[left]);
            
            // Update the DP array for the next iterations
            dp[right + 1] = Math.max(dp[right], currentSegmentPrizes);
        }

        return maxPrizes;
    }
}
/*
so have to return count of gift can select 
problem difficult as don't know which 2 segments give max no of gift ??

so first let stores all location - no of gifts 

so 
1-2
2-2
3-2
5-2 

now this segment can be any thing like seperate or overlap 
so how to find ??

if k=0 then ans always 2 

brute force => 
for each  i consider it as starting part of segment and find max no of gift possible to get from that - will
    it provide all cases ?? => YESSSS

but have to select 2 segment so for that we do that remove segment 1 from array then check again by it ??
will it give second best place ?? yes 

// edge case if diff of arr[n-1]-arr[0] >= k then answer is arr.length


so solution is that check 
by genrating all subsets but for subset use nlogn by using binary search to find the ens of subset 

and then after finding ssegment 1 range delete that part from arr then check again and do the sum of both range if 
*/