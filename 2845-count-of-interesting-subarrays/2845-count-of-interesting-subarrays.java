class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        int[] p = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            if(i>0) p[i]+=p[i-1];
            if(nums.get(i)%m==k) p[i]++;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        long count=0;
        for(int i=0;i<nums.size();i++){
            int val = (p[i]-k)%m;
            if(val<0) val+=m;
            if(map.containsKey(val)) count+=map.get(val);
             map.put(p[i]%m,map.getOrDefault(p[i]%m,0)+1);
        }
        return count;
    }
}

// [l,r] find no of nums[i]%m==k and if count of these no nums[i] cnt%m==k then ans++;
// count= p[j]-p[i]
// so we want (p[j]-p[i])%m==k then (p[j]-p[i]) congruence k(%m)
// (p[j]-k)%m = p[i]%m;

// where p[x] is no of nums[i]%m==k