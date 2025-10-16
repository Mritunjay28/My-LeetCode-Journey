class Solution {
    public int findSmallestInteger(int[] nums, int val) {
        int n= nums.length;
        int[] freq = new int[val+1];
        for(int i=0;i<n;i++){
            int rem = nums[i]%val;
            if(rem<0) rem+=val;
            rem%=val;
            freq[rem]++;
        }

        int x=0;
        while(true){
            int find = x%val;
            if(freq[find]==0) return x;
            freq[find]--;
            x++;
        }
    }
}