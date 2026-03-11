class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        StringBuilder sb = new StringBuilder();
        int x=n;
        while(x>0){
            int rem = x%2;
            if(rem==0) sb.append('1');
            else  sb.append('0');
            x/=2;
        }


        return Integer.parseInt(sb.reverse().toString(),2);
    }
}