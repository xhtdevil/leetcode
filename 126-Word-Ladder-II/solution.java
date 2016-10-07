public class Solution {
    class wordLink {
        String word;
        wordLink parent;
        wordLink(String word, wordLink parent) {
            this.word = word;
            this.parent = parent;
        }
        wordLink(String word) {
            this.word = word;
            this.parent = null;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<wordLink> set = new HashSet<wordLink>();
        Set<String> visited = new HashSet<String>();
        boolean end = false;
        set.add(new wordLink(beginWord));
        List<List<String>> ans = new ArrayList<List<String>>();
        //int len = 1;
        while(!set.isEmpty() && !end) {
            Set<wordLink> temp = new HashSet<wordLink>();
            for(wordLink link : set) {
                char[] c = link.word.toCharArray();
                for(int i = 0; i < c.length; i++) {
                    char old = c[i];
                    for(int j = 0; j < 26; j++) {
                        c[i] = (char) ('a' + j);
                        String str = String.valueOf(c);
                        if(endWord.equals(str)) {
                            List<String> list = new ArrayList<String>();
                            list.add(endWord);
                            wordLink linkNode = link;
                            while(linkNode != null) {
                                list.add(0,linkNode.word);              //notice order in the list
                                linkNode = linkNode.parent;
                            }
                            ans.add(list);
                            end = true;
                        }
                        if(wordList.contains(str) && c[i] != old) {
                            temp.add(new wordLink(str, link));
                            //visited.add(str);
                        }
                    }
                    c[i] = old;
                }
            }
            set = temp;
            //len++;
        }
        return ans;
    }
}