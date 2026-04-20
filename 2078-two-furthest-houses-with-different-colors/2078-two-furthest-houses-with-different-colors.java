class Solution {
    public int maxDistance(int[] colors) {
        int max =-1;
        boolean first =false;
        for(int i=0;i<colors.length;i++){
            for(int j=colors.length-1;j>i;j--){
                if(colors[i]!=colors[j]) {
                    max=Math.max(j-i,max);
                   // first= true;
                    break;
                }
            }
           // if(first) break;
        }

        return max;
    }
}