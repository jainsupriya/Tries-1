class Solution {
    
    private class Trie {
        private class TrieNode{
            Map<Character, TrieNode> children ;
            String word ;
            public TrieNode(){
                children = new TreeMap<>(Collections.reverseOrder());
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
            node.word = word;
        }        
        private String findLongestWord() {
            String result = null;
            Queue<TrieNode>  q= new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TrieNode node = q.poll();
                    for(char c: node.children.keySet()){
                        if(node.children.get(c).word != null){
                            result = node.children.get(c).word;
                            q.add(node.children.get(c));
                        }
                    }
                }
            }
            return result;
        }
    }
    Trie trie;
    public String longestWord(String[] words) {
        trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
        return trie.findLongestWord(); 
    }    
}
