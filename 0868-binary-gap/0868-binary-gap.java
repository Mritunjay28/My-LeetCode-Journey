class Solution {
    public int binaryGap(int n) {
        int max =0;
        int prev=-1,count=0;
        int x =n;
        while(x>0){
            int rem = x%2;
            count++;
            if(rem==1){
                if(prev==-1) prev=count;
                else {
                    max=Math.max(max,count-prev);
                    prev=count;
                }
            }
            x/=2;
        }
        return max;
    }
}