class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        int[] ans = new int[nums.length];
    
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<pivot) small.add(nums[i]);
            else  if(nums[i]==pivot) equal.add(nums[i]);
            else   large.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++) {
            if(i<small.size()) ans[i]=small.get(i);
            else if ( i<small.size()+equal.size()) ans[i]=equal.get(i-small.size());
            else ans[i]=large.get(i-small.size()-equal.size());
        }

        return ans;
    }
}