class Solution {
    public long maximumScore(int[] nums, String s) {
      long count=0;
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      for(int i=0;i<s.length();i++){
        pq.add(nums[i]);
        if(s.charAt(i)=='1') {
            count+=pq.peek();
            pq.poll();
        }
      }
      return count;
    }
}