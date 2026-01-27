class Solution {
    class State{
        int x;
        boolean isbackward;
        State(int x, boolean y){
            this.x=x;
            this.isbackward=y;
        }
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> set = new HashSet<>();
        int furthest = x + a + b;
        for(int y : forbidden){
            set.add(y);
            furthest = Math.max( furthest ,y+a+b);
        } 
        Queue<State> q = new LinkedList<>();
        int level=0 ;
        q.add(new State(0,true));
        while(!q.isEmpty()){
            int l =q.size();
            for(int i=0;i<l;i++){
                State curr = q.poll();
                int u = curr.x ;
                boolean isbackward=curr.isbackward;
                if(u==x) return level;
                // can always go forward 
                if(u+a <= furthest && set.add(u+a)) q.offer(new State(u+a,true));
                // for back check if neg or double back
                if(isbackward && u-b>=0 && set.add(u-b)) q.offer(new State(u-b,false));
            }
            level++;
        }

        return -1;

    }
}