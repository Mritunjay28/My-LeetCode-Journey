class Solution {

    public int passThePillow(int n, int time) {
        int curr = 1;
        int t = 0;
        int dir = 1;
        while (t < time) {
            if ( 0 < curr + dir && curr + dir <= n) {
                curr += dir;
                t++;
            } 
            else dir *= -1; 
        }
        return curr;
    }
}