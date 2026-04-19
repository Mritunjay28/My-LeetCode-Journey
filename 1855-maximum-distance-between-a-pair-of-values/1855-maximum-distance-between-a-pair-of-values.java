class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans=0;
        for(int j=nums2.length-1;j>=0;j--){
            int val = nums2[j];
            // find val index or index with value<val
            int i = bs(val,nums1);
            if(i<=j) ans=Math.max(ans,j-i);
        }
        return ans;
    }

    public int bs(int x , int[] arr){
        int s = arr.length-1,e=0;
        int ans =-1;
        while (s>=e ){
            int mid = s+(e-s)/2;
            if(arr[mid]<=x){
                ans=mid;
                s=mid-1;
            }
            else e=mid+1;
        }

        if(ans==-1) return (int) 1e6+1;
        return ans;
    }
}