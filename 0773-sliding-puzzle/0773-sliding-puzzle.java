class Solution {
    public int slidingPuzzle(int[][] board) {
    // when flatten board then index (0,0) (1) have right, down now if we index the current index on based of row*(length of column) + col then it is 0 similarly rigt is 1 , and down is 3 .....
        int[][] directions = new int[][] {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 1, 3, 5 },
            { 2, 4 },
        };

        String target = "123450";
        StringBuilder startState = new StringBuilder();

       
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                startState.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>(); 
        Queue<String> queue = new LinkedList<>();
        queue.add(startState.toString());
        visited.add(startState.toString());

        int moves = 0;

      
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currentState = queue.poll();

              
                if (currentState.equals(target)) {
                    return moves;
                }

                int zeroPos = currentState.indexOf('0'); // we take index which match with flattern array;
                for (int newPos : directions[zeroPos]) {
                    String nextState = swap(currentState, zeroPos, newPos);

                  
                    if (visited.contains(nextState)) continue;

                   
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
            moves++;
        }
        return -1;
    }

    
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}