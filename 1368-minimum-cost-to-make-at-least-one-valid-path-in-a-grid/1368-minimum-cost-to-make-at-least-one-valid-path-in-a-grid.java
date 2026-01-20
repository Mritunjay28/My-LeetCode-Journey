class Solution {
    class State{
        int r;
        int c;
        int cost;
        State(int i,int j,int cost){
            this.r=i;
            this.c=j;
            this.cost=cost;
        }
    }
    public int minCost(int[][] grid) {
        int n = grid.length ,m=grid[0].length;
        int k=1;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        Deque<State> dq =new ArrayDeque<>(); // if cost 0 add to front if cost 1 then add to back
        // boolean[][][] visited = new boolean[n][m][1]; 
        int[][] cost = new int[n][m]; // contain minimum cost to reach that point
        for(int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);

        dq.addFirst(new State(0,0,0));
        cost[0][0]=0;

        while(!dq.isEmpty()){
            State curr = dq.pollFirst();
            if(curr.cost > cost[curr.r][curr.c]) continue;
            if(curr.r==n-1 && curr.c==m-1) return curr.cost;

            for(int i=0;i<4;i++){
              int nr =curr.r +dir[i][0];
              int nc =curr.c +dir[i][1];

              if(nr>=0 && nr<n &&nc>=0 && nc<m ){
                int weight = (grid[curr.r][curr.c]==i+1)? 0 :1;
                int newcost = curr.cost + weight;

                if(newcost < cost[nr][nc]){
                    cost[nr][nc] =newcost;
                    if(weight==0) dq.addFirst(new State(nr,nc,newcost));
                    else dq.addLast(new State(nr,nc,newcost));
                }
              }  
            }
        }

        return cost[n-1][m-1];
    }
}

/*
as in this que we donot worry about shortest path we can use 0-1 bfs if cost 0 then add front of dq else back of dq by doing this we process 0 cost first then 1 cost 
here state keep track of i,j,cost till that point 
*/