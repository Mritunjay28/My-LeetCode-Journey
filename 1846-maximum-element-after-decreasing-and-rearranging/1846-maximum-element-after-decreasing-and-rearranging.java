class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int prev=1;
        for(int i=1;i<n;i++){
            if(arr[i]-prev >1) {
                prev+= 1;
            }
            else prev=arr[i];
        }
        return prev;
    }
}