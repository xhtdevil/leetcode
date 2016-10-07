public class Solution {
    // class wordLink {
    //     String word;
    //     wordLink parent;
    //     wordLink(String word, wordLink parent) {
    //         this.word = word;
    //         this.parent = parent;
    //     }
    //     wordLink(String word) {
    //         this.word = word;
    //         this.parent = null;
    //     }
    // }
    // public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    //     Set<wordLink> set = new HashSet<wordLink>();
    //     Set<wordLink> endset = new HashSet<wordLink>();
    //     Set<String> visited = new HashSet<String>();
    //     boolean end = false;
    //     endset.add(new wordLink(endWord));
    //     set.add(new wordLink(beginWord));
    //     List<List<String>> ans = new ArrayList<List<String>>();
    //     //int len = 1;
    //     while(!set.isEmpty() && !end) {
    //         if(endset.size() < set.size()){}
    //         Set<wordLink> temp = new HashSet<wordLink>();
            
    //         for(wordLink link : set) {
    //             char[] c = link.word.toCharArray();
    //             for(int i = 0; i < c.length; i++) {
    //                 char old = c[i];
    //                 for(int j = 0; j < 26; j++) {
    //                     c[i] = (char) ('a' + j);
    //                     String str = String.valueOf(c);
    //                     if(endWord.equals(str)) {
    //                         List<String> list = new ArrayList<String>();
    //                         list.add(endWord);
    //                         wordLink linkNode = link;
    //                         while(linkNode != null) {
    //                             list.add(0,linkNode.word);              //notice order in the list
    //                             linkNode = linkNode.parent;
    //                         }
    //                         ans.add(list);
    //                         end = true;
    //                     }
    //                     if(wordList.contains(str) && c[i] != old) {
    //                         temp.add(new wordLink(str, link));
    //                         //visited.add(str);
    //                     }
    //                 }
    //                 c[i] = old;
    //             }
    //         }
    //         set = temp;
    //         //len++;
    //     }
    //     return ans;
    // }
    
    Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
    Map<String, Integer> dis = new HashMap<String, Integer>();
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> sol = new ArrayList<String>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        for(String s : wordList) {
            neighbors.put(s, new ArrayList<String>());
        }
        dis.put(beginWord, 0);
        bfs(beginWord, endWord, wordList, q);
        dfs(beginWord, endWord, wordList);
        return ans;
    }
    
//     public List<List<String>> findLadders(String start, String end, Set<String> dict) {      
//       List<List<String>> res = new ArrayList<List<String>>();         
//       HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
//       HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
//       ArrayList<String> solution = new ArrayList<String>();
    
//       dict.add(end);          
//       bfs(start, end, dict, nodeNeighbors, distance);                 
//       dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
//       return res;
// }

    
    private void bfs(String beginWord, String endWord, Set<String> wordList, Queue<String> q) {
        boolean endFlag = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String str = q.poll();
                int curDis = dis.get(str);
                neighbors.put(str, findNeighbors(str, wordList));
                for(String neighbor : neighbors.get(str)){
                    if(!dis.containsKey(neighbor)){
                        dis.put(neighbor, dis.get(str) + 1);
                        if(endWord.equals(neighbor)) {
                            endFlag = true;
                        }
                        else {
                            q.offer(neighbor);
                        }
                    }
                }
            }
            if(endFlag) break;
        }
    }
    
    // private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
    //   for (String str : dict)
    //       nodeNeighbors.put(str, new ArrayList<String>());
    
    //   Queue<String> queue = new LinkedList<String>();
    //   queue.offer(start);
    //   distance.put(start, 0);
    
    //   while (!queue.isEmpty()) {
    //       int count = queue.size();
    //       boolean foundEnd = false;
    //       for (int i = 0; i < count; i++) {
    //           String cur = queue.poll();
    //           int curDistance = distance.get(cur);                
    //           ArrayList<String> neighbors = getNeighbors(cur, dict);
    
    //           for (String neighbor : neighbors) {
    //               nodeNeighbors.get(cur).add(neighbor);
    //               if (!distance.containsKey(neighbor)) {// Check if visited
    //                   distance.put(neighbor, curDistance + 1);
    //                   if (end.equals(neighbor))// Found the shortest path
    //                       foundEnd = true;
    //                   else
    //                       queue.offer(neighbor);
    //                   }
    //               }
    //           }
    
    //           if (foundEnd)
    //               break;
    //       }
    //   }

    private List<String> findNeighbors(String str, Set<String> wordList) {
        List<String> res = new ArrayList<String>();
        char[] c = str.toCharArray();
        for(int i = 0; i < str.length(); i++) {
            char old = c[i];
            for(char a = 'a'; a <= 'z'; a++) {
                if(a == c[i]) continue;
                c[i] = a;
                String s = String.valueOf(c);
                if(wordList.contains(s)) {
                    res.add(s);
                }
            }
            c[i] = old;
        }
        return res;
    }
    
    private void dfs(String beginWord, String endWord, Set<String> wordList) {
        sol.add(beginWord);
        if(endWord.equals(beginWord)) ans.add(new ArrayList<String>(sol));
        else {
            for(String s : neighbors.get(beginWord)) {
                if(dis.get(s) == dis.get(beginWord) + 1) {
                    dfs(s, endWord, wordList);
                }
            }
        }
        sol.remove(sol.size() - 1);
    }
}