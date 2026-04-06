class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
      HashSet<String> set = new HashSet<>();
      for(int[] obs: obstacles){
        set.add(obs[0]+","+obs[1]);
      }
      int x=0;
      int y=0;
      int maxx=0;
      int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
      int d=0;
      for(int command:commands) {
        if(command==-1){
            d++;
            d=d%4;
        }
        else if(command==-2){
            d--;
            d=(d+4)%4;
        }
        else{
            for(int i=0;i<command;i++){
                int xx=x+dir[d][0];
                int yy=y+dir[d][1];
                if(set.contains(xx+","+yy)) break;
                x=xx;
                y=yy;
            }

        }
        maxx=Math.max(maxx,x*x+y*y);
      }
      return maxx;
    }
}