class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int currentXor = arr[i];
           
            for (int k = i + 1; k < n; k++) {
                currentXor ^= arr[k];
                
                if (currentXor == 0) {
                    count += (k - i);
                }
            }
        }
        
        return count;
    }
}