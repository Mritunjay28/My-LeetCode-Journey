class Solution {
    public int countOperations(int nums1, int nums2) {
        int count=0;
        while(nums1!=0 && nums2!=0){
            if(nums1>nums2) nums1-=nums2;
            else if(nums1<nums2) nums2-=nums1;
            else nums1=0;
            count++;
        }
        return count;
    }
}