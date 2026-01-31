class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int minidx=0;
        int mindiff=Integer.MAX_VALUE;

        for(int i=0;i<letters.length;i++){
            if(target < letters[i]) {
                int diff = letters[i] - target ;
                if(diff<mindiff) {
                    mindiff= diff;
                    minidx=i;
                }
            }
        }

        return letters[minidx];

    }
}