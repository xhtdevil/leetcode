public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        if(s.length() == 0 && p.length() == 0) return true;
        while(i < s.length() || j < p.length()) {
            
            if(i < s.length() && j == p.length()) return false;
            //if(i == s.length() && j < p.length())if(p.charAt()
            if(i < s.length() && s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            else if(p.charAt(j) != '.' && p.charAt(j) != '*' ) {
                if(j != p.length() - 1 && p.charAt(j + 1) == '*') {
                    j += 2;
                }
                else return false;
            }
            else if(p.charAt(j) == '*') {
                if(j == 0)return false;
                //if(i == s.length()) return isMatch(s.substring(i), p.substring(j + 1));
                int m = i - 1;
                while(m < s.length() && s.charAt(m) == p.charAt(j - 1)) {
                    if(isMatch(s.substring(m), p.substring(j + 1))) return true;
                    m++;
                }
                if(isMatch(s.substring(m), p.substring(j + 1))) return true;
                else return false;
            }
            else {
                if(j == p.length() - 1 || p.charAt(j + 1) != '*') {
                    if(i >= s.length()) return false;
                    i++;
                    j++;
                } 
                else {
                    int m = i;
                   // char c = s.charAt(m);
                    while(m < s.length()) {
                        if(isMatch(s.substring(m), p.substring(j + 2))) return true;
                        m++;
                    }
                    if(isMatch(s.substring(m), p.substring(j + 2))) return true;
                    else return false;
                }
            }
            
        }
        return true;
    }
}