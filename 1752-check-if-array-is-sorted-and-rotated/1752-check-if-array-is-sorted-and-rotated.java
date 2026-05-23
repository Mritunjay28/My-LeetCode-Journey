class Solution {
    public boolean check(int[] nums) {
        int n =nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=nums[i];

        Arrays.sort(arr);
         for (int offset = 0; offset < n; offset++) {
            boolean isMatch = true;
            for (int i = 0; i < n; i++) {
                if ( nums[(offset + i) % n] != arr[i] ) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch)  return true;
        }

        return false;
    }
}