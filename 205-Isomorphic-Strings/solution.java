public class Solution {
    public boolean isIsomorphic(String s, String t) {
       // if(s.length() != t. length()){return false;}
        Map<Character,Integer> sMap = new HashMap<Character,Integer>();
        Map<Character,Integer> tMap = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        //     if(sMap.get(s.charAt(i)) != tMap.get(t.charAt(i))){
        //         return false;
        //     }else{
        //         sMap.put(s.charAt(i), i);
        //         tMap.put(t.charAt(i), i);
        //     }
        // }
        return true;
    }
}