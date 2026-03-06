class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        int[] newHeights = new int[heights.length + 1];// to be able to apply for last index
        for (int i = 0; i < heights.length; i++) {
            newHeights[i] = heights[i];
        }
        newHeights[heights.length] = 0;

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) { 
                // when found less than previous height
                int height = newHeights[stack.pop()]; // pop that height
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1); 
                // give less than one width
                maxArea = Math.max(maxArea, height * width);

            }
            stack.push(i); // contain index of height
        }

        return maxArea;
    }
}