class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(k,1);

        int sum=0;
        int count=0;
        for(int x : nums){
            sum+=x;
            if(map.containsKey(sum)) count+=map.get(sum);
            
            map.put(sum+k,map.getOrDefault(sum+k,0)+1);
        }

        return count;
    }
}

// as contain neative number so cannot be sliding window 
// prefix[j] - prefix[i] = k
// 

