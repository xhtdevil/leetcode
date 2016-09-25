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
    TrieNode root;
    public WordDictionary(){
        TrieNode root = new TrieNode();
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
            if(i != word.length() - 1)node.isWord = false;
            else node.isWord = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode root = new TrieNode();
        return match(word, 0, root);
    }
    
    public boolean match(String word, int index, TrieNode root){
        TrieNode node = root;
        for(int i = index; i < word.length(); i++){
            if(word.chatAt(i) == '.'){
                for(int j = 0; j < 26; j++){
                    if(node.children[j] != null)match(word, i + 1, node.children);
                }
            }
            if(node.children[word.charAt(i) - 'a'] == null)return false;
            else node = node.children[word.charAt(i) - 'a'];
            if(i == word.length() - 1 && node.isWord == false)return false;
        }
        return true;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");