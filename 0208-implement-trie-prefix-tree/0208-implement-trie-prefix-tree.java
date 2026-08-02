class Trie {

    class TreeNode{
        boolean isEnd;
        TreeNode children[];

        TreeNode(){
            this.isEnd = false;
            this.children = new TreeNode[26];
        }
    }

    TreeNode root;
    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode curr = root;

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null) curr.children[idx] = new TreeNode();

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchInTrie(word,0,root);
    }

    public boolean searchInTrie(String word,int i, TreeNode curr){
        if(i==word.length() && curr.isEnd) return true;
        else if(i>=word.length()) return false;

        int idx = word.charAt(i) - 'a';
        
        if(curr.children[idx]==null) return false;


        return  searchInTrie(word, i+1, curr.children[idx]);
    }
    
    public boolean startsWith(String prefix) {
        return startInTrie(prefix,0,root);
    }

    public boolean startInTrie(String word,int i, TreeNode curr){
        if(i==word.length()) return true;
      
        int idx = word.charAt(i) - 'a';
        
        if(curr.children[idx]==null) return false;


        return  startInTrie(word, i+1, curr.children[idx]);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */