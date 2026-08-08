import java.util.Arrays;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[] lastPos = new int[m + 1];
        Arrays.fill(lastPos, -1);
        lastPos[m] = n; 

        int p1 = n - 1;
        for (int p2 = m - 1; p2 >= 0; p2--) {
            while (p1 >= 0 && word1.charAt(p1) != word2.charAt(p2)) {
                p1--;
            }
            lastPos[p2] = p1;
            if (p1 >= 0) {
                p1--; 
            }
        }

       
        int[] ans = new int[m];
        boolean changed = false;
        int i = 0; 

        for (int j = 0; j < m; j++) {
            boolean placed = false;

            while (i < n) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    ans[j] = i;
                    i++;
                    placed = true;
                    break;
                } 
                else if (!changed && lastPos[j + 1] > i) {
                    ans[j] = i;
                    changed = true;
                    i++;
                    placed = true;
                    break;
                }
                i++;
            }

            if (!placed) {
                return new int[0];
            }
        }

        return ans;
    }
}