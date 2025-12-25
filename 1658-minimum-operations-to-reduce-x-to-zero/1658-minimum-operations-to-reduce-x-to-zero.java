class Solution {
    public int minOperations(int[] nums, int x) {
        int total =0;
        for(int n : nums ) total+=n;

        if(total-x<0) return -1;
        if (total-x == 0) return nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int l=-1;
        for(int i=0;i<nums.length;i++){
            if(i>0) nums[i]+=nums[i-1];
            int val = nums[i]+x-total;
            if(map.containsKey(val)) l =Math.max(l,i-map.get(val));
           if(!map.containsKey(nums[i])) map.put(nums[i],i);
        }
        return (l==-1) ? -1 : nums.length-l;
    }
}
// p[j]-p[i] = total-x;
// p[j]+x-total = p[i]; 