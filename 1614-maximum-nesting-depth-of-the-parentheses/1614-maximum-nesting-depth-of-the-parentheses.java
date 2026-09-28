class Solution {
    public int maxDepth(String s) {
        int max=0;
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                stack.push('(');
                max=Math.max(max,stack.size());
            }
            if(s.charAt(i)==')') {
                stack.pop();
            }
        }

        return max;
    }
}