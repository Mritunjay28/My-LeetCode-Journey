class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> {
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]) ;
            else return Integer.compare(a[1],b[1]);
        });

        List<int[]> list = new ArrayList<>();
        int s = intervals[0][0] , e=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(e>=intervals[i][0]) e=Math.max(e,intervals[i][1]);
            else{
                list.add(new int[] {s,e});
                s=intervals[i][0];
                e=intervals[i][1];
            }
        }

          list.add(new int[] {s,e});

        int[][] ans = new int[list.size()][2];
        int i=0;
        for(int[] k : list){
            ans[i][0]=k[0];
            ans[i][1]=k[1];
            i++;
        }

        return ans;

    }
}