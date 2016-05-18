public class Solution {
    public int titleToNumber(String s) {
        //List<char> charArray = new ArrayList<char>();
        //charArray = s.toCharArray();
        int num = 0;
        for(int i = 0;i < s.length();i++){
            num = num + ((int) s.charAt(i) - 64) * (int) Math.pow(26,(s.length() - i - 1)) ;
        }
    return num;
    }
}