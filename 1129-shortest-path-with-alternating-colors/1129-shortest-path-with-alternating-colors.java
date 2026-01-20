class Solution {
    class State{
        int u;
        int colour;
        State(int u,int colour){
            this.u=u;
            this.colour=colour;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redadj = new ArrayList<>();
        List<List<Integer>> blueadj = new ArrayList<>();

        for(int i=0;i<n;i++){
            redadj.add(new ArrayList<>());
            blueadj.add(new ArrayList<>());
        }

        for(int i=0;i<redEdges.length;i++) {
            int u =redEdges[i][0] , v =redEdges[i][1] ;
            redadj.get(u).add(v);
        }

         for(int i=0;i<blueEdges.length;i++) {
            int u =blueEdges[i][0] , v =blueEdges[i][1] ;
            blueadj.get(u).add(v);
        }

        int[] ans = new int[n];
        for(int i=1;i<n;i++){ // 0-red , 1-blue
            boolean pathexist = false;
            int step =0;
            boolean[][] visited = new boolean[n][2];
            Queue<State> q = new LinkedList<>();
            q.add(new State(0,0));
            q.add(new State(0,1));
            visited[0][0] =true;
            visited[0][1] =true;
            while(!q.isEmpty()){
                int l = q.size();
                for(int j=0;j<l;j++){
                    State curr = q.poll();
                    if(curr.u == i){
                        ans[i]=step;
                        pathexist=true;
                        break;
                    }
                    int colour =curr.colour;
                    if(colour ==0){
                        for(int v : blueadj.get(curr.u)){
                            if(!visited[v][1-colour]) {
                                visited[v][1-colour] =true;
                                q.add(new State(v,1-colour));
                            }
                        }
                    }
                    else{
                        for(int v : redadj.get(curr.u)){
                            if(!visited[v][1-colour]) {
                                visited[v][1-colour] =true;
                                q.add(new State(v,1-colour));
                            }
                        }
                    }
                  
                }
                if(pathexist) break;
                step++;
            }
            if(!pathexist) ans[i]=-1;
        }
        return ans;
    }
}