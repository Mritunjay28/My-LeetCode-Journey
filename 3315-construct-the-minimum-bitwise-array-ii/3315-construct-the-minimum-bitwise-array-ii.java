class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
           int n =nums.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int res=-1;
            int d=1;
            
            while((nums.get(i) &d)!=0){
                res= nums.get(i)-d;
                d<<=1;
            } 

            ans[i]= res;
        }
        return ans;
    }
}