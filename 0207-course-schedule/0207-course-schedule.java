class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree  = new int[numCourses];
        for(int i=0;i<numCourses;i++)  adj.add( new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
            indegree[v]++;
        }

       Queue<Integer> q = new LinkedList<>();
       int count=0;
       for(int i=0;i<numCourses;i++) {
        if(indegree[i]==0){
            q.add(i);
            count++;
        } 
       }

       while(!q.isEmpty()){
            int u = q.poll();
            for(int v :adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                    count++;
                }
            }
       }

       if(count==numCourses) return true;
       return false;
    }
}