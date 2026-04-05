class Solution {
    public boolean judgeCircle(String moves) {
        int currx =0,curry=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L') currx--;
            else if(moves.charAt(i)=='R') currx++;
            else if(moves.charAt(i)=='U') curry++;
            else curry--;
        }

        if(currx==0 && curry==0) return true;
        return false;
    }
}