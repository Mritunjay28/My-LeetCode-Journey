class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max=Integer.MIN_VALUE;

        for(int i=k;i<energy.length;i++){
            int prev = energy[i-k];
            if(prev>=0){
                energy[i]+=prev;
            }
        }

        for(int i=energy.length-1;i>energy.length-1-k;i--) max= Math.max(max,energy[i]);

        return max;

    }
}

/*
 0 1  2  3  4 5 6 7  8 9 10 11
[5,2,-10,-5,1,2,5,-1,0,8,-6, 5,12], k = 3 , ans= 13

[5,2,-10,0,3,2,5,-2,2,13,-6,7,25] max in this is answer 

take max of first k no then , from k+1 add it's i-k idx value to current if i-k idx value >0 
else no need to add remain it as it is just check if max   

 */