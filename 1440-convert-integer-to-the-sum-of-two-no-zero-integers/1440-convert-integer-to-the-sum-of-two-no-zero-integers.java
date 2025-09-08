class Solution {

    private boolean notzero(int n){
        while(n>0){
            if(n%10==0) return false;
            n/=10;
        }
        return true;
    }



    public int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];
        for(int i=1;i<n;i++){
            int j= n-i;
            if(notzero(i) && notzero(j)) {
                arr[0]=i;
                arr[1]=j;
                return arr;
            }
        }
        return arr;
    }
}