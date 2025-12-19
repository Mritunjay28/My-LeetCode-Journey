class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
       List<List<int[]>> adj = new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());
       for(int i=0;i<meetings.length;i++) {
        int x=meetings[i][0],y=meetings[i][1],t=meetings[i][2]; 
        adj.get(x).add(new int[] {y,t});
        adj.get(y).add(new int[] {x,t});
       }

       int[] earliest =new int[n];
       Arrays.fill(earliest,Integer.MAX_VALUE);
       earliest[0]=0;
       earliest[firstPerson]=0;

       PriorityQueue<int[]> q =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
       q.offer(new int[]{0,0});
       q.offer(new int[]{firstPerson,0});


       while(!q.isEmpty()){
        int[] persontime = q.poll();
        int person = persontime[0] ,time =  persontime[1];

        if (time > earliest[person]) continue;

        for(int[] v : adj.get(person)){
            int t = v[1] , next = v[0];
            if(t>=time && earliest[next]>t){
                earliest[next] = t;
                q.offer(new int[] {next,t});
            }
        }
       }

       List<Integer> ans =new ArrayList<>();
       for(int i=0;i<n;i++){
        if(earliest[i] != Integer.MAX_VALUE) ans.add(i);
       }
       return ans;
    }
}