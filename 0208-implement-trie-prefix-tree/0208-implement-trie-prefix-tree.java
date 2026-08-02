class Trie {

    class TreeNode {
        boolean isEnd;
        TreeNode children[];

        TreeNode() {
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

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new TreeNode();

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null)
                return false;

            curr = curr.children[idx];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null)
                return false;

            curr = curr.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */