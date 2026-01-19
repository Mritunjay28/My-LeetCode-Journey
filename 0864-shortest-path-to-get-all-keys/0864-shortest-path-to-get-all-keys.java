class Solution {
    class State{
        int r;
        int c;
        int mask;
        State(int r,int c,int k){
            this.r=r;
            this.c=c;
            this.mask=k;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        int n= grid.length , m =grid[0].length();
        int k=0;
        int startR = -1, startC = -1;
        for(int i=0;i<n;i++){
           for (int j = 0; j < m; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    startR = i;
                    startC = j;
                }
                else if (ch >= 'a' && ch <= 'f') k++;
            }
        }

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][][] visited = new boolean[n][m][1<<k];
        Queue<State> q = new LinkedList<>();
        q.add(new State(startR,startC,0));
        visited[startR][startC][0] = true;
        int step=0;
        while(!q.isEmpty()){
            int l =q.size();
            for(int i=0;i<l;i++){
                State temp = q.poll();
                int r =temp.r;
                int c =temp.c;
                int mask = temp.mask;

                if(mask==(1<<k)-1) return step;
                for(int[] d:dir){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m){
                        int newmask=mask;
                        char ch = grid[nr].charAt(nc);
                        if(ch=='#') continue;
                        if(ch>='A' && ch<='F') if((newmask &(1<<(ch-'A')))==0) continue; // lock key not present
                        if(ch>='a' && ch<='f') newmask|=(1<<(ch-'a'));
                        if(!visited[nr][nc][newmask]){
                            visited[nr][nc][newmask]=true;
                            q.add(new State(nr,nc,newmask));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}

/*
Adding an item: newMask = currentMask | (1 << keyId)

Checking an item: if ((currentMask & (1 << keyId)) != 0) item present 

Goal Check: if (currentMask == (1 << totalKeys) - 1)

*/