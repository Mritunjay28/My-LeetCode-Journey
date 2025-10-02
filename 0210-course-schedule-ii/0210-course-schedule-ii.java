class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                List<List<Integer>> adj = new ArrayList<>();
        int[] indegree  = new int[numCourses];
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++)  adj.add( new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
            indegree[u]++;
        }

       Queue<Integer> q = new LinkedList<>();
       int count=0;
       for(int i=0;i<numCourses;i++) {
        if(indegree[i]==0){
            q.add(i);
            count++;
        } 
       }

        int i=0;
       while(!q.isEmpty()){
            int u = q.poll();
            ans[i++]=u;
            for(int v :adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                    count++;
                }
            }
       }

       if(count==numCourses) return ans;
       return new int[0];
    }
}