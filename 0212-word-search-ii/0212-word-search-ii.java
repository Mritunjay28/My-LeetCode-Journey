class Solution {
    List<String> res;
    int m ,n;

    class TreeNode{
        String word;
        TreeNode[] children;
        boolean isEnd;

        TreeNode(){
            this.word="";
            this.children = new TreeNode[26];
            this.isEnd=false;
        }
    }

    public void insertNode(String word , TreeNode root){
        TreeNode curr = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(curr.children[ch-'a']== null){
               curr.children[ch-'a'] = new TreeNode();
            }

            curr =  curr.children[ch-'a'];
        }

        curr.word=word;
        curr.isEnd = true;  
    }

    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public void findTrieNode(int i,int j,char[][]board,TreeNode root){
        if(i<0 || i>m-1 || j<0 || j>n-1) return ;

        if(board[i][j]=='$' || root.children[board[i][j] -'a']== null) return;

        root = root.children[board[i][j] -'a'];

        if(root.isEnd) {
            res.add(root.word);
            root.isEnd = false;
        }
        
        char temp = board[i][j] ;
        board[i][j]='$';

        for(int[] d : dir) {
            int x = i+d[0];
            int y = j+d[1];

            findTrieNode(x,y,board,root);
        }

        board[i][j]=temp;
    }


    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        TreeNode root = new TreeNode();

        for(String word : words) insertNode(word ,  root);

        res = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int ch = board[i][j] - 'a';
                if(root.children[ch]!= null) findTrieNode(i,j,board,root);
            }
        }

        return res;
    }
}