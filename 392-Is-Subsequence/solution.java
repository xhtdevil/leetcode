public class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for(int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), new ArrayList<Integer>());
            }
            map.get(t.charAt(i)).add(i);
        }
        int prev = 0;
        for(int j = 0; j < s.length(); j++) {
            if(!map.containsKey(s.charAt(j))) return false;
            
            else {
                int m = Collections.binarySearch(map.get(s.charAt(j)), prev);
                if(m < 0)m = - m - 1;
                if(m == map.get(s.charAt(j)).size())return false;
                prev = map.get(s.charAt(j)).get(m) + 1;
            }
        }
        return true;
    }
}