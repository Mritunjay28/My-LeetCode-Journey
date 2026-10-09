class Solution {
    public int minInsertions(String s) {
        int openCount = 0;
        int insertions = 0;
        int i = 0, n =s.length();

        while(i<n){
            char ch = s.charAt(i);

            if(ch == '(') {
                openCount++;
            }
            else{
                if(i + 1 <n && s.charAt(i+1) == ')'){
                    i++;
                }
                else{
                    insertions++;
                }

                if(openCount > 0){
                    openCount--;
                }
                else{
                    insertions++;
                
                }
            }
            i++;
        }
        insertions += openCount * 2;

        return insertions;
    }
}