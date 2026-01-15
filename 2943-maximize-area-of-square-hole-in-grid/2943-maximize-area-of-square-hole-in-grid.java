class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // HashSet<Integer> hset =new HashSet<>();
        // HashSet<Integer> vset =new HashSet<>();

        // for(int i=0;i<hBars.length;i++) hset.add(hBars[i]);
        // for(int i=0;i<vBars.length;i++) vset.add(vBars[i]);

        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxx=1;
      int curr=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]==hBars[i-1]+1){
                curr++;
            }
            else curr=1;
            maxx=Math.max(maxx,curr);
        }

        int maxy=1;
        curr=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]==vBars[i-1]+1) curr++;
            else curr=1;
            maxy=Math.max(maxy,curr);
        }

        int max=Math.min(maxx,maxy)+1;
        return (int)Math.pow(max,2);
    }
}