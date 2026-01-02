class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] arr = new int[10001];
        for(int i:nums) arr[i]++;
        int max=-1,maxidx=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) {
                max=arr[i];
                maxidx=i;
            }
        }

        return maxidx;
    }
}