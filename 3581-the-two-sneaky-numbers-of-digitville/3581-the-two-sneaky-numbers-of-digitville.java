class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[nums.length];
        for(int i=0;i<nums.length;i++) freq[nums[i]]++;
        int[] ans =new int[2];
        int k=0;
        for(int i=0;i<freq.length;i++) if(freq[i]==2) ans[k++]=i;
        return ans;
    }
}