class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length; 
        long prefix[] = new long[n]; 
        int ans[] = new int[shifts.length];
        prefix[0] = tasks[0]; 
        for(int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + tasks[i]; 

     
        long currwork = 0; 
        for(int i = 0; i < shifts.length; i++) {
            currwork += shifts[i]; 
            ans[i] = n - bs(prefix, currwork); 
            if(ans[i] == 0) {
                currwork = 0;  
            }
        }
        return ans; 
    }

    private int bs(long[] arr, long t) {
        int low = 0;
        int high = arr.length; 

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= t) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
