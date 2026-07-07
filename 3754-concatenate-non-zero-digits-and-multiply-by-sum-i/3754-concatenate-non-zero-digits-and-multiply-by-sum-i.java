class Solution {
    public long sumAndMultiply(int n) {
        long x =n;
        long sum=0;
        long[] arr = new long[11];
        int l=0;
        while(x>0){
            long rem = x%10;
            arr[l++]=rem;
            x/=10;
        }

        x=0;
        for(int i=10;i>=0;i--){
            if(arr[i]!=0){
                sum+=arr[i];
                x =x*10+arr[i];
            }
        }

        return x * sum;
        
        
    }
}