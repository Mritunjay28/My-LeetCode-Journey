class Solution {
    public int minAbsoluteDifference(int[] nums) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) one.add(i);
            if(nums[i]==2) two.add(i);
        }


        if(one.size() == 0 || two.size()==0) return -1;
        int min =Integer.MAX_VALUE;

        for(int x : one){
            for(int y : two) {
                min=Math.min(min,Math.abs(y-x));
            }
        }

        return min;
    }
}