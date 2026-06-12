class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
       
        for(int i=1;i<n;i++){
         nums[i]= (int)(((long)nums[i] + nums[i-1]) % p);
        } 
        if(nums[n-1]%p==0) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int l = 100000000;

        for(int i=0;i<n;i++){
            int val = nums[i]%p;
            if(val<0) val+=p;

            int needed = (val-nums[n-1]+p)%p;

            if(map.containsKey(needed)) l = Math.min(l,i-map.get(needed));
            map.put((val)%p,i);
        }

        return (l==100000000 || l==n) ? -1:l;
    }
}

// (p[n-1] - (p[j]-p[i-1]) ) %p==0
// where j and i-1 closest 
// p[n-1] = a then 
// a-(p[j]-p[i-1]) conguence 0%p
// p[j] congruence a+p[i-1]%p

// p[j]%p =(a+p[i-1]) %p
// but in hashmap always isolate p[i-1](past) term so 
// p[i-1] = p[j] - a (mod p)
// p[i-1]%p = (p[j]-a)%p
// in above code p[j]=val , a = nums[n-1] , done +p for negative remainder 
// and we stored p[j]%p in hashmap 
// LHS of the equation refer to past , so have store this in hashmap
// RHS of equation refer to present and thing to search currently - always contain all constant term 
// if anything negative then +p to it 