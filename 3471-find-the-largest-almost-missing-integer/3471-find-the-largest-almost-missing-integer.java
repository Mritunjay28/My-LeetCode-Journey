class Solution {
    public int largestInteger(int[] nums, int k) {
        if(nums.length==k){
            int max=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>max){
                    max=nums[i];
                }
            }
            return max;
        }
        int s=0,e=k-1;
        int[] freq= new int[55];
      while(e<nums.length){
       for(int i=s;i<=e;i++){
          freq[nums[i]]++;
       }   
        s++;e++;
      }
        int max=-1;
        for(int i=0;i<freq.length;i++){
            if(freq[i]==1 && i>max){
                max=i;
            }
        }
        return max;
    }
}