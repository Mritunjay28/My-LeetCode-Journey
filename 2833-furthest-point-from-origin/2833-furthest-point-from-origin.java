class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l=0,r=0,s=0;
        for(char ch : moves.toCharArray()) {
            if(ch=='L') l++;
            else if (ch=='R') r++;
            else s++;
        }

        return s+Math.abs(l-r);
    }
}