class Solution {
    public int minimumDeletions(String s) {
        int n= s.length();
        Stack<Character> stack = new Stack<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else{
                if(s.charAt(i)=='a' && stack.peek()=='b') {
                    stack.pop();
                    count++;
                }
                else  stack.push(s.charAt(i));
            }
        }

        return count;
    }
}