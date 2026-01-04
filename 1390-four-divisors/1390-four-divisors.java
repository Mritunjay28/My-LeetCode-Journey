class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i]; 
            int val =n+1;
            int count=2;
            for(int j=2;j<=(int)Math.sqrt(n);j++){
                if(n%j==0) {
                    if(count>4){
                        break;
                    }
                    val+=j;
                    count++;
                    if(j!=(int)(n/j)){
                        val+=(int)(n/j);
                        count++;
                    } 
                   
                }
            }

            if(count==4) sum+=val;
        }

        return sum;
    }
}

/*
want sum of divisor of integer that have exactely 4 divisor 
how to find a no divisor 
like 1 and itself are always same so bassically no with only 1 more and no/ factorial if equal then add 1s only  
*/