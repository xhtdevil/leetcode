class TrieNode{
        public char val;
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
        public TrieNode() {}
        TrieNode(char c){
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }
    
public class WordDictionary {
    private TrieNode root = new TrieNode();
    public WordDictionary(){
        root.val = ' ';
    }
    // Adds a word into the data structure.
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            if(node.children[word.charAt(i) - 'a'] == null){
                node.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            node = node.children[word.charAt(i) - 'a'];
            if(i == word.length() - 1)node.isWord = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    public boolean match(String word, int index, TrieNode root){
        TrieNode node = root;
        for(int i = index; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                for(int j = 0; j < 26; j++){
                    if(node.children[j] != null && match(word, i + 1, node.children[j]) == true)return true;
                }
                return false;
            }
            else{
                if(node.children[word.charAt(i) - 'a'] == null)return false;
                else node = node.children[word.charAt(i) - 'a'];
                if(i == word.length() - 1 && node.isWord == false)return false;
            }
        }
        return node.isWord;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");