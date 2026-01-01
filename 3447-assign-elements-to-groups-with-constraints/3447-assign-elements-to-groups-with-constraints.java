class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
       int maxg = Arrays.stream(groups).max().orElse(-1);
       int[] best = new int[maxg+1];
       Arrays.fill(best,-1);

       for(int i=0;i<elements.length;i++){
        int x = elements[i];
        if(x>maxg || best[x]>=0) continue;
        for(int j=x;j<=maxg;j+=x){
            if(best[j]<0) best[j]=i;
        }
       }


       int[] ans = new int[groups.length];
       for(int i=0;i<groups.length;i++) ans[i] = best[groups[i]];

       return ans;
    }
}
// basically we want to know that at ith idx in groups which elements are divisible and at what jth idx 