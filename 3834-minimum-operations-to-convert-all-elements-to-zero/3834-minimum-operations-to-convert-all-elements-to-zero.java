class Solution {
    public int minOperations(int[] nums) {
      ArrayList<Integer> arr = new ArrayList<>();
      int count=0;
      for(int i=0;i<nums.length;i++){
        while(!arr.isEmpty() && arr.get(arr.size()-1) > nums[i]) arr.remove(arr.size()-1);
        if(nums[i]==0) continue;
        if(arr.isEmpty() || arr.get(arr.size()-1) < nums[i]){
            count++;
            arr.add(nums[i]);
        }
      }

      return count;
    }
}