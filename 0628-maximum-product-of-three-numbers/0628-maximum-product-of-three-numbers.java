class Solution {
    public int maximumProduct(int[] nums) {
        int n= nums.length;
        if(n==3) return nums[0]*nums[1]*nums[2];
        Arrays.sort(nums);
        int smallest = nums[0];
        int secondsmallest = nums[1];
        int thirdsmallest = nums[2];
        int largest = nums[n-1];
        int secondlargest = nums[n-2];
        int thirdlargest = nums[n-3];

        // all neg then 3 largest values  
        // all positive then 3 largest values

        // if mix 1 neg then 3 largest 
        // if 2 neg then check if smallest *secondsmallest > secondlargest*thirdlargest
        // if 3 or more then also 2 neg then largest 

        if(largest <=0 || smallest >=0){
            return largest * secondlargest * thirdlargest;
        }

        if(secondsmallest >=0) return largest * secondlargest * thirdlargest;
       
            int negmax = smallest * secondsmallest;
            int posmax = secondlargest * thirdlargest;

            return largest* Math.max(negmax,posmax);
        
        
    }
}