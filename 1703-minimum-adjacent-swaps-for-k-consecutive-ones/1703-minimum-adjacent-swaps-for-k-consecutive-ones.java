class Solution {
    public int minMoves(int[] nums, int k) {
        int countOnes = 0;
        for (int x : nums) {
            if (x == 1) countOnes++;
        }

        // Store pure raw indices
        long[] a = new long[countOnes];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                a[idx++] = i;
            }
        }

        // Prefix sums of raw indices
        long[] pref = new long[countOnes + 1];
        for (int i = 0; i < countOnes; i++) {
            pref[i + 1] = pref[i] + a[i];
        }

        // Precompute the constant offset for this window size k
        long leftCount = k / 2;
        long rightCount = (k - 1) - leftCount;
        long offset = (leftCount * (leftCount + 1) / 2) + (rightCount * (rightCount + 1) / 2);

        long minMoves = Long.MAX_VALUE;

        for (int i = 0; i <= countOnes - k; i++) {
            int mid = i + k / 2;
            long medianVal = a[mid];

            // Standard distance to median using raw indices
            long leftSum = pref[mid] - pref[i];
            long leftCost = (mid - i) * medianVal - leftSum;

            long rightSum = pref[i + k] - pref[mid + 1];
            long rightCost = rightSum - (long)((i + k - 1) - mid) * medianVal;

            // Subtract the fixed offset because elements end up adjacent, not on the exact same cell
            long totalCost = (leftCost + rightCost) - offset;
            minMoves = Math.min(minMoves, totalCost);
        }

        return (int) minMoves;
    }
}
/*
so first try to check if have consucutive 1 >=k then 0 

if not then try to form like group of 1st together

like 1 3 6 with start and end 
like 1 - 2,2 
3- 4,6
6- 10,16

now for each we have to check left and right ? 
nesscary ? taking largest only ?? nope like 1101100000000000000111 k=4 -> ans = 2
so have to check all 

now how to check 
for each val find no of required 1s to satisfy k , then check if for each index in list if required amount of 1s present in left or right 
but it will require location od all 1s as we want the location of 1 from current i .

so if we maintain list with only 1s indexes ?
eg : nums = [0,1,0,0,1,0,0,0,0,0,0,1,1,1,1] k= 5 
list = [1,4,11,12,13,14] k= 5

then sliding window ???
it work .

// nmow for 110110000111 k=4 -> ans = 2 ??
// prev=0,st=0;
// [1,2,4,5,10,11,12] k= 4
// [1,2,4,5,10,11,12] k= 4
// prev=0,curr=1 ok prev++;
// prev=1,curr=2 ok prev++;
// prev=2,curr=4 preoblem so gap = e-prev-1; so 4-2-1 = 1 , prev++;
// prev=3,curr=5 preoblem so gap = e-prev-1; so 5-3-1 = 1 , prev++; cost =2

// // initial window over now 
// now prev=4, curr =10 so gap = 10-4-1 = 5
// but k = 5 so nums[s]-st-1 = 1-0-1 = 0 so add 0 to gap cost = 2+5=7

// 101100001 = 4+4+6 

but problem like around which index in window to search for minimum no of operation  ??
->  Median 

now if we select median then for each window cost = sumof(b[mid]-b[j]) for j=i to j=mid-1 +
                                                    sumof(b[j]-b[mid]) for j=mid+1 to j=i+k-1

it can be minimize into left = countleft*b[mid] - sum of b[j] for j=i to j=mid-1
and right =  sum of b[j] for j=mid+1 to j=i+k-1 - counttright*b[mid]

so we just want sum of B[i] which can be done through prefix sum 
*/