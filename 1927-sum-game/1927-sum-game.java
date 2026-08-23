class Solution {
    public boolean sumGame(String num) {
        int diff = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) == '?') left++;
            else diff += num.charAt(i) - '0';
        }

        for (int i = num.length() / 2; i < num.length(); i++) {
            if (num.charAt(i) == '?') right++;
            else diff -= num.charAt(i) - '0'; 
        }
        
        if ((right + left) % 2 == 1) return true;

        if (left == right) return diff != 0;
        
        int round = (left - right) / 2;

        if (diff * round >= 0) return true;

        return Math.abs(diff) != Math.abs(round * 9);
    }
}