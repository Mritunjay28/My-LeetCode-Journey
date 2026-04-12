class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                boolean prime = isprime(nums[i]);
                if(prime) continue;
                int nextprime = findprime(nums[i]);
                count += (nextprime - nums[i]);
            }
            else{
                boolean prime = isprime(nums[i]);
                if(!prime) continue;
                if(nums[i]==2) count+=2;
                else count++;
            }
        }
        return count;
    }

    public boolean isprime(int n){
        if(n<=1) return false;

        for(int i=2;i*i<=n;i++) if(n%i==0) return false;

        return true;
    }

    public int findprime(int n) {
    int num = n + 1;

    if (num <= 2) return 2;
   
    if (num % 2 == 0) num++;

    while (!isprime(num)) {
        num += 2;
    }

    return num;
}
}