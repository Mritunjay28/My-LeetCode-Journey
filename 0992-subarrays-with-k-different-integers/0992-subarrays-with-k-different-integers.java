class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }

    public int atmost(int[] nums, int k){
        if(k==0) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        int s=0,e=0;
        int count=0;
        while(e<nums.length){
            map.put(nums[e],map.getOrDefault(nums[e],0)+1);
            if(map.get(nums[e])==1) k--;

            while(k<0){
                map.put(nums[s],map.get(nums[s])-1);
                if(map.get(nums[s])==0){
                    map.remove(nums[s]);
                    k++;
                }
                s++;
            }

            count+= (e-s+1);
            e++;
        }

        return count;
    }
}