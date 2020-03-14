/*
Time Complexity : O(N) where N is the length of the sentence
*/
class Solution {
    private class Trie {
        private class TrieNode{
            Map<Character, TrieNode> children ;
            String word ;
            public TrieNode(){
                children = new HashMap<>();
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
         /*Time complexity : O(m) where m is the length of the longest word
        Space complexity : O(1) */
        /** Returns if the word is in the trie. */
        public String search(String word) {
            TrieNode node =  root;
            for(char c: word.toCharArray()){
                if(!node.children.containsKey(c) || node.word != null) break;
                node = node.children.get(c); 
            }
            return node.word;
        }
    }
    Trie trie ;
    StringBuilder sb; 
    public String replaceWords(List<String> dict, String sentence) {
        trie = new Trie();
        sb = new StringBuilder();
        //build trie
        for(String s: dict)
            trie.insert(s);
        
        String [] words  = sentence.split("\\s+");
        for(String s: words){
            //search replacement for every word;
            String replacement = trie.search(s);
            //if we find the replacement, return the replaced word 
            //or return the word only.
            sb.append( (replacement == null) ? s : replacement).append(" ");
        }
        return sb.toString().trim();
    }
}
