class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
     
        boolean[] visited = new boolean[26];
         
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
           
            count[c - 'a']--;
            
            if(visited[c - 'a'])  continue;
            
            
            
            while(!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0)
                visited[stack.pop() - 'a'] = false;
            
            
            stack.push(c);
            
            visited[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}