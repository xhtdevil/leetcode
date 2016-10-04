public class Solution {
    public char findTheDifference(String s, String t) {
        int a = 0;
        for(int i = 0; i < s.length(); i++) {
            a ^= (s.charAt(i) - 'a');
            a ^= (t.charAt(i) - 'a');
        }
        a ^= (t.charAt(s.length()) - 'a');
        char ans = (char) ('a' + a);
        return ans;
    }
}