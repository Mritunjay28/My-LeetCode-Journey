class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n =nums.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(nums.get(i)==2){
                ans[i]=-1;
                continue;
            }
            int idx=-1;
            for(int j=0;j<10;j++){
                if((nums.get(i) &(1<<j))!=0) idx=j;
                else break;
            } 
            if(idx==-1) ans[i]=-1;
            else ans[i]= (nums.get(i) ^(1<<idx));
        }
        return ans;
    }
}
// a| (a+1) = nums[i];
// so it find last 0 bit turn to 1 and less bit then it to 1 
// we can only form nums[i] if it contain consecutive 1 from back , odd no always contain 1 so only in 2 -1
// now for a 

// 3(011) we can fron prev by last 1 so 010(2) | 001(1) then 011 
// 5(101) we can form prev by last 1 so 101(5) | 100(4) then 101
// 7(0111) we can form prev by last 1 so  0011(3) |0100(4) then 0111