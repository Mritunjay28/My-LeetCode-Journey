class Solution {
    public int[] shuffle(int[] nums, int n) {
        int p1=0,p2=n;
        int[] ans = new int[2*n];
        for(int i=0;i<2*n;i+=2){
            ans[i]=nums[p1++];
            ans[i+1]=nums[p2++];
        }
        return ans;
    }
}