class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            if (s.charAt(i) == '(') {
                stack.push('(');
                i++;
                while (!stack.isEmpty()) {
                    if (s.charAt(i) == ')') {
                        StringBuilder curr = new StringBuilder();
                        while (stack.peek() != '(') {
                            curr.append(stack.pop());
                        }
                        stack.pop();
                        if (!stack.isEmpty()) {
                            for (int j = 0; j < curr.length(); j++)
                                stack.push(curr.charAt(j));
                        } 
                        else {
                            sb.append(curr.toString());
                            break;
                        }
                    }
                    else stack.push(s.charAt(i));
                    i++;
                }
            }
             else sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
/*
(u(love)i) => (uevoli) => iloveu
u(love)i => uevoli 

so have to ensure that first character to in stack is '(' then find till got ')' and end all brackets 

*/