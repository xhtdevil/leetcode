public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String strs[] = str.split(" ");
        Map<Character,String> match = new HashMap<Character,String>();
        if(pattern.length() != strs.length){return false;}
        for(int i = 0; i < pattern.length(); i++){
            if(match.containsKey(pattern.charAt(i)) && !match.get(pattern.charAt(i)).equals(strs[i]) ){return false;}
            else if(match.containsValue(strs[i])){
                if(!match.containsKey(pattern.charAt(i))){return false;}
                else if(!match.get(pattern.charAt(i)).equals(strs[i])){return false;}
            }else if(!match.containsKey(pattern.charAt(i)) && !match.containsValue(strs[i])){match.put(pattern.charAt(i), strs[i]);}
        }
        return true;
    }
}