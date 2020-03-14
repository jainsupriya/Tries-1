class Trie {
    private class TrieNode{
        Map<Character, TrieNode> children ;
        boolean endOfWord ;
        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    /*Time complexity : O(m) where m is the length of the longest word
    Space complexity : O(m) where m is the length of the longest word*/
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node =  root;
        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c))
                node.children.put(c, new TrieNode());
            node = node.children.get(c);
        }
        node.endOfWord = true;
    }
     /*Time complexity : O(m) where m is the length of the longest word
    Space complexity : O(1) */
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node =  root;
        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return node.endOfWord;
    }
    /*Time complexity : O(m) where m is the length of the longest word
    Space complexity : O(1) */
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node =  root;
        for(char c: prefix.toCharArray()){
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
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
