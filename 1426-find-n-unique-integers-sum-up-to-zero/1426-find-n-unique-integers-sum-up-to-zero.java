class Solution {
    public int[] sumZero(int n) {
        int[] arr= new int[n];
        boolean iseven = (n%2==0) ? true :false;

        int time= n/2;
        if(iseven){
            int i=0;
            while(time>= -n/2){
                if(time==0) {
                    time--;
                    continue;
                    }
                arr[i]=time;
                time--;
                i++;
            }
        }
        else {

             int i=0;
            while(time>= -n/2){
                arr[i]=time;
                time--;
                i++;
            }
        }
        return arr;
    }
}