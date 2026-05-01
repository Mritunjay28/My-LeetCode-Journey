class Solution {
    public int maxRotateFunction(int[] nums) {
        long max =Integer.MIN_VALUE;
        long sum=0;
        long rowsum=0;
        for(int i=0;i<nums.length;i++){
            sum+= (nums[i]*i);
            rowsum+=nums[i];
        }

        max=Math.max(max,sum);
        int e =nums.length-1;
        for(int i=1;i<nums.length;i++){
            long val = sum;
            val+=rowsum;
            val-=nums[e];
            val-= ((nums.length-1)*nums[e]);
            e--;
            max=Math.max(max,val);
            sum=val;
        }

        return (int)max;

    }
}

/*
25 + (4+3+2+6 -nums[e] ) - n-1*nums[e]
*/