class Solution {
    public int countPermutations(int[] complex) {
        int smallest = complex[0] ;
        for(int i=1;i<complex.length;i++) if(smallest >=complex[i]) return 0;

        int l = complex.length - 1;
        int mod = 1000000007;
        long ans =1;
        for(int i=l;i>1;i--){
            ans = (ans*i*1L)%mod;
        }      

        return (int)ans;  

    }
}

// we are checking if for each their idx except 0 is their any smaller complexity before it if yes then their can be permutataion else no 