class Solution {
    public int bestClosingTime(String customers) {
       
        int a=customers.length();
        int x=0;
        int[] y = new int[a+1];

         for(int i=a;i>=0;i--){
            y[i]=x;
            if(i>=1 && customers.charAt(i-1)=='Y') x++;
        }

        // for(int b:y) System.out.print(b+" ");

        x=0;
        int[] n = new int[a+1];
        for(int i=1;i<a+1;i++){
            if( customers.charAt(i-1)=='N') x++;
            n[i]=x;  
        }

        // System.out.println(" ");

        // for(int b:n) System.out.print(b+" ");

        int min=1000000,minidx=-1;
        for(int i=0;i<a+1;i++){
            int val = y[i]+n[i];
            if(val<min){
                min=val;
                minidx=i;
            }
        }

        return minidx;
    }
}
// YYNY - then y=3,n=1
// if close at 0 then -y
// if close at 1 right no of y =2 
// if close at 2 right no of y =1 
// if close at 3 right no of y and no of n to left =1+1 
// if close at 4 right no of y and no of n to left =0+1  
// so basically want no of n to the left including current and
// no of y to right not including current 