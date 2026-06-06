class Solution {
    public long countBadPairs(int[] nums) {
        int n =nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        long count =0;
       for(int i=0;i<n;i++){
        int val = i-nums[i];

        if(map.containsKey(val)) count+=map.get(val);

        map.put(val,map.getOrDefault(val,0)+1);
       }

       long ans = (long)n * (n - 1) / 2;


       return ans - count;


    }
}

/*
j-i != nums[j] - nums[i]

find pair where 
j-i = nums[j] - nums[i] 

total pairs = n*n+1 /2

sub them 

on changing 
j-nums[j] = i-nums[i];

*/