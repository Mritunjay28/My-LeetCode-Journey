class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        arr[n - 1] = nums[1];
        int idx = 0,
            rev = n - 1;
        for (int i = 2; i < n; i++) {
            if (arr[idx] > arr[rev]) {
                arr[++idx] = nums[i];
            } else {
                arr[--rev] = nums[i];
            }
        }
        for (int l = rev, r = n - 1; l < r; l++, r--) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        return arr;
    }
}