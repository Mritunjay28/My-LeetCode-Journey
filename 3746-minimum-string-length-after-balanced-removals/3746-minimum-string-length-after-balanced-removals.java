class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> stack = new Stack<>();
        int count=0,min=1000000;
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else{
                if(s.charAt(i)=='b' && stack.peek()=='a'){
                    stack.pop();
                }
                else if(s.charAt(i)=='a' && stack.peek()=='b'){
                    stack.pop();
                } 
                else stack.push(s.charAt(i));
            }
        }
       
        return stack.size();
    }
}