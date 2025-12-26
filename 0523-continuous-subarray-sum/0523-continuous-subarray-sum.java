class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            if(i>0) nums[i]= ((nums[i]%k) +(nums[i-1]%k))%k;
            int val = nums[i]%k;
            if(map.containsKey(val) && i-map.get(val)>=2) return true;
            if(!map.containsKey(val)) map.put(val,i);
        }
        return false;
    }
}
// (p[j]-p[i] )%k=0 and j-i+1 = 2 but as we do i=-1 so j-i>=2
// p[j]%k = p[i]%k if neg then add k 