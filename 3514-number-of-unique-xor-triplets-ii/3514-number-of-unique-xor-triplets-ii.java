class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max=nums[0];

        for(int x : nums) max = Math.max(max,x);

        int max2power = 1;
        while(max2power <= max) max2power <<=1;

        boolean[] a = new boolean[max2power];

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                a[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] b = new boolean[max2power];
        for(int i=0;i<max2power;i++){
            if(!a[i]) continue;

            for(int x : nums){
                b[i ^ x] = true;
            }
        }

        int count=0;
        for(boolean x : b) if(x) count++;


        return count;
    }
}