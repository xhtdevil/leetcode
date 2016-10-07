public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	Set<String> set = new HashSet<String>();
    	Set<String> visited = new HashSet<String>();
    	set.add(beginWord);
    	int len = 1;
    	while(!set.isEmpty()) {
    		Set<String> temp = new HashSet<String>();
    		for(String s : set) {
    			char[] c = s.toCharArray();
    			//char[] old = c;
    			for(int i = 0; i < c.length; i++) {
    			    char old = c[i];
    				for(int j = 0; j < 26; j++) {
    					c[i] = (char)('a' + j);
    					String str = String.valueOf(c);
    					if(str.equals(endWord)) {
    						return len + 1;
    					}
    					if(wordList.contains(str) && !visited.contains(str) && old != c[i]) {
    						temp.add(str);
    						visited.add(str);
    					}
    				}
    				c[i] = old;
    			}
    		}
    		len++;
    		set = temp;
    	}
    	return 0;
    }
}