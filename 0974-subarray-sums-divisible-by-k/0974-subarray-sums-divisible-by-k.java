class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
       
        for(int i=0;i<nums.length;i++){
            if(i>0) nums[i]+=nums[i-1];
            int val = nums[i]%k;
            if(val<0) val+=k;
            if(map.containsKey(val)) count+=map.get(val);
            map.put(val,map.getOrDefault(val,0)+1);
        }

        return count;

    }
}
// (pj-pi)%k=0
// pj-pi congruence 0(%k)
// pj congruence pi(%k)
// pj%k = pi%k if negative add k