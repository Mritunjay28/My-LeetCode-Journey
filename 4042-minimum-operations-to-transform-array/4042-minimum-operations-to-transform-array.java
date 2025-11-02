class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
          int n = nums1.length;
        long res = 0L;
        long append = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long x = (long)( nums2[n] - nums1[i]);
            long y = (long) (nums2[n]- nums2[i]);
            if((long)(x*y) < 0) {
                append = 0L;
                break;
            }
            append =(long) Math.min(append,Math.abs(x)); 
            append = (long)Math.min(append,Math.abs(y));
        }
        
        for(int i=0;i<n;i++){
            res += (long)Math.abs(nums1[i]-nums2[i]);
        }
        return (long)(res+append+1L);
    }
}