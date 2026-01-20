class Solution {
    class State{
        int u;
        int mask;
        State(int u,int mask){
            this.u=u;
            this.mask=mask;
        }
    }
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n==1) return 0;
        int k=n;
        boolean[][] visited = new boolean[n][1<<k];
        Queue<State> q =new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(new State(i,1<<i));
            visited[i][1<<i] =true;
        }

        int step=0;
        while(!q.isEmpty()){
            int l =q.size();
            for(int i=0;i<l;i++){
                State curr = q.poll();
                int u = curr.u;
                int mask = curr.mask;
                for(int v : graph[u]){
                    int newmask = mask;
                      // mark this path 
                    newmask|= 1<<v;

                     // check if complete all node
                    if(newmask==(1<<k)-1) return step+1;
                   
                    if(!visited[v][newmask]){
                        visited[v][newmask]=true;
                        q.add(new State(v,newmask));
                    }
                }
            }
            step++;
        }

        return -1;
    }
}

// add item mask|= 1<<currkey
// check if item present (mask & (1<<currkey)) !=0 ,item present
// check if complete (mask == ((1<<k)-1) // done