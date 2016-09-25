public class Solution {
    
    // my solution without bFS timed out
    // Map<String[], Integer> map = new HashMap<String[], Integer>();
    
    // public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    //     Map<String, Boolean> used = new HashMap<String, Boolean>();
    //     return help(beginWord, endWord, wordList, used);
    // }
    
    // private int help(String beginWord, String endWord, Set<String> wordList, Map<String, Boolean> used) {
        
    //     String[] pair = new String[2];
    //     pair[0] = beginWord;
    //     pair[1] = endWord;
        
    //     if(map.containsKey(pair)){
    //         return map.get(pair);
    //     }
        
    //     if(oneDifference(beginWord, endWord)){
    //         map.put(pair, 1);
    //         return 2;
    //     }
        
    //     int minStep = Integer.MAX_VALUE;
        
    //     for(String s : wordList) {
    //         if(oneDifference(s, beginWord) && (!used.containsKey(s) || used.get(s) == false)) {
    //             used.put(s, true);
    //             int step = help(s, endWord, wordList, used);
    //             if(step == 0)continue;
    //             step = step + 1;
    //             if(step < minStep) minStep = step;
    //             used.put(s, false);
    //             step = step - 1;
    //         }
    //     }
        
    //     if(minStep == Integer.MAX_VALUE) {
    //         return 0;
    //     }
        
    //     map.put(pair, minStep);
    //     return minStep;
        
    // }
    
    // private boolean oneDifference(String s1, String s2) {
    //     int count = 0;
    //     for(int i = 0; i < s1.length(); i++){
    //         if(s1.charAt(i) != s2.charAt(i))count++;
    //         if(count > 1)return false;
    //     }
    //     return count == 1;
    // }
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int len = 1;
        int strlen = beginWord.length();
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> visited = new HashSet<String>();
            
            for(String s : beginSet) {
                Set<String> temp = new HashSet<String>();
                char[] chs = s.toCharArray();
                for(int i = 0; i < strlen; i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String str = String.valueOf(chs);
                        if(endSet.contains(str)) return len + 1;
                        else if(wordList.contains(str) && !visted.contains(str)) {
                            temp.add(str);
                            visited.add(str);
                        }
                        chs[i] = old;
                        
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        
        return 0;
        
    }
}