class Solution {
    public int rotatedDigits(int n) {
        if(n<2) return 0;
        if(n<5) return 1;
        if(n<6) return 2;
        if(n<9) return 3;
       int count=0;
       if(n>=9) count=4;
       for(int i=10;i<=n;i++){
        int x = i;
        boolean flag=false;
        while(x>0){
            int rem= x%10;
            if(rem==3 || rem==4 || rem==7){
                flag=false;
                break;
            }
            if(rem==2||rem==5||rem==6||rem==9) flag=true;
            x/=10;
        }

        if(flag) count++;
       }

       return count;
    }
}