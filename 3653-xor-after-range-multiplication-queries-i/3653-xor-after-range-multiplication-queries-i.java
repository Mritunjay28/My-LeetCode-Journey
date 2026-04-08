class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int mod = (int) 1e9+7;
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0] ;
            int r=queries[i][1] ;
            int k=queries[i][2] ;
            long v=queries[i][3] ;

            while(l<=r){
                long u = ((long)nums[l]*v)%mod;
                nums[l]= (int) u;
                l+=k;
            }
        }

        int ans=nums[0];
        for(int i=1;i<n;i++) ans^=nums[i];

        return ans;
    }
}