public class Solution {
    public boolean isAnagram(String s, String t) {
        int letterCount = 26;
        int[] unicodes = new int[letterCount];
        int[] unicodet = new int[letterCount];
        for(int i = 0; i < letterCount; i++){
            unicodes[i] = 0;
            unicodet[i] = 0;
        }
        if(t.length() != s.length()){
            return false;
        }
        for(int i = 0; i < t.length(); i++){
            unicodes[(int)s.charAt(i) - 'a']++;
            unicodet[(int)t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < letterCount; i++){
            if(unicodes[i] != unicodet[i]){
                return false;
            }
        }
        return true;
    }
}