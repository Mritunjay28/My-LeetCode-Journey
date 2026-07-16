class Solution {
    public long gcdSum(int[] nums) {
        long[] a = new long[nums.length];
        int max =-1;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
            a[i]=max;
        } 

        long[] prefix = new long[nums.length];
        for(int i=0;i<nums.length;i++) prefix[i] = gcd(nums[i],a[i]);

        Arrays.sort(prefix);

        long sum =0;
        int s = 0, e = nums.length-1;
        while(s<e){
            sum+= gcd(prefix[s],prefix[e]);
            s++;
            e--;
        }

        return sum;
        
    }

    public long gcd (long a ,long b){
        while(b!=0){
            long temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}