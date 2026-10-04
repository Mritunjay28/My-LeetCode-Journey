class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBrackets = new Stack <> ();
        Stack<Integer> asterisks = new Stack <> ();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') openBrackets.push(i); 
            else if (ch == '*') asterisks.push(i);
            else {
                // If there are open brackets available, use them to balance the closing bracket
                if (!openBrackets.empty()) openBrackets.pop();
                // If no open brackets are available, use an asterisk to balance the closing bracket
                else if (!asterisks.isEmpty()) asterisks.pop();
                else return false;
            }
        }

        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {
            // If an open bracket appears after an asterisk, it cannot be balanced, return false
            if (openBrackets.pop() > asterisks.pop()) return false; // '*' before '(' which cannot be balanced.
        }

        // If all open brackets are matched and there are no unmatched open brackets left, return true
        return openBrackets.isEmpty();
    }
}