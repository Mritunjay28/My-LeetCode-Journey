class Solution {
    public int maxDistance(int[] colors) {
        int size = colors.length;
        int l = 0, r = size - 1;

        while (colors[0] == colors[l] && colors[l] == colors[r]) {
            l++;
            r--;
        }

        return r;
    }
}