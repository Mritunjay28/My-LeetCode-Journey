class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs((long) nums[i]);
        }

        Arrays.sort(arr);
        long count = 0;
        int j = 0;
       
        for (int i = 0; i < n; i++) {
            if (j < i + 1) j = i + 1;
            while (j < n && arr[j] <= 2 * arr[i]) {
                j++;
            }
            count += (j - i - 1);
        }

        return count;
    }
}

// let not lose basic a<=b we can do this by sorting
// if we take absolute of all number then sort then a=> |a| , b=> |b| , |b|>=|a|
// now min(|a|, |b|) = |a| ,max(|a|, |b|)=|b|
//  min(|a - b|, |a + b|) if a=>|a| , b=>|b| then 
// min(|a - b|, |a + b|) = min(||a| - |b||, ||a| + |b||)
// min(||a| - |b||, ||a| + |b||) = ||a| - |b||
// ||a| - |b|| = |b| - |a| ,identity |a-b| = |b-a|

// therefore |b|-|a| <= |a| , |b| <=2|a|

// and in second |a|+|b|>=|b| , |a|>=0 always true  