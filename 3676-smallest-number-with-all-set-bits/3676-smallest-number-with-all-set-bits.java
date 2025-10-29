class Solution {
    public int smallestNumber(int n) {
        int[] set = {1,3,7,15,31,63,127,255,511,1023};
        for(int i=0;i<set.length;i++) if(n<=set[i]) return set[i];
        return -1;
    }
}