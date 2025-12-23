class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            return a[0]-b[0];
        });

        PriorityQueue<Integer> pq =new PriorityQueue<>();
        int count=0;
        for(int i=1,j=0;i<100001;i++) {

            while(!pq.isEmpty() && pq.peek()<i){
                pq.poll();
            }

            while(j<events.length && events[j][0]<=i){
                pq.add(events[j][1]);
                j++;
            }

            if(!pq.isEmpty() && pq.peek()>=i){
                count++;
                pq.poll();
            }

        }

        return count;
    }
}