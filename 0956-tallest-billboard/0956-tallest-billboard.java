class Solution {
    int[][] memo;
    int OFFSET = 5000;
    public int tallestBillboard(int[] rods) {
        memo = new int[rods.length][10001];
        for(int i=0;i<rods.length;i++) Arrays.fill(memo[i],-1);

        int ans = f(0,rods,0);
        return (ans<0) ?  0: ans/2;
    }

    public int f(int i,int[] arr,int curr){
        if(i==arr.length){
            if(curr==0) return curr;
            else return -(int)1e6;
        }
        if(memo[i][curr+OFFSET] !=-1) return memo[i][curr+OFFSET];
        // take 
        int take =f(i+1,arr,curr+arr[i])+arr[i];
        //nottake
        int nottake=f(i+1,arr,curr-arr[i])+arr[i];
        //skip
        int skip=f(i+1,arr,curr);

        return memo[i][curr+OFFSET]= Math.max(take, Math.max(nottake,skip));
    }
}
/*
have to divide array into 2  parts may include or not 

both side same size 
so like if we have x as curr height then from remaining we have to find if an x is also possible 

by take not take we can do like divide it into 2 part then do the take or not take and find if we can make it .
but tc high .

it is dp but how ?? => we awant t= 2s+k so want highest value which cna form fro arr and is divisible by 2 
 


*/