class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max=0;
        while(i<j){
            int small = Math.min(height[i],height[j]);
            max=Math.max(max,small*(j-i));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
}