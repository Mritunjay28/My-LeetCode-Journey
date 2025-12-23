class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n=nums.length;
        int mod =1000000007;
        long[] arr = new long[n];
        for(int i=0;i<requests.length;i++){
            arr[requests[i][0]]++;
            if(requests[i][1]+1 <n)  arr[requests[i][1]+1]--;
        }

        for(int i=1;i<n;i++) arr[i]= (arr[i]+arr[i-1])%mod;

        Arrays.sort(arr);

        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) pq.add(nums[i]);
        long ans=0;
        for(int i=n-1;i>=0;i--){
            ans=(ans+ (arr[i]*pq.poll())%mod)%mod;
        } 

        return (int)ans;
    }
}