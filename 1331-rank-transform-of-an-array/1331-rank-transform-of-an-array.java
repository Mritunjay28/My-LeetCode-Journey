class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(int i=0;i<arr.length;i++) q.add(new int[] {arr[i],i});
        

        int rank =0;
        int prev= Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==prev) arr[curr[1]]=rank;
            else{
                rank++;
                arr[curr[1]]=rank;
                prev=curr[0];
            }
        }

        return arr;
    }
}