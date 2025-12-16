class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans = 1000000;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))  ans= Math.min(ans,i-map.get(nums[i]));
            int x=0;
            int a=nums[i];
            while(a>0){
                x=x*10 + a%10;
                a/=10;
            }
            map.put(x,i);
        }
        return (ans==1000000) ? -1 : ans;
    }
}