class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int x= target[0] , y =target[1];
        int totalstepbyus = Math.abs(x) + Math.abs(y);

        // minimum step by ghost
        for(int i=0;i<ghosts.length;i++){
            int steps = Math.abs(x-ghosts[i][0]) + Math.abs(y-ghosts[i][1]);
            if(steps<=totalstepbyus) return false; 
        } 
        return true;
    }
}

// notice packman can stay still so if packman can reach target first than player than we will always lose
// in each turn we can go up,down,right,left 