public class Solution {
    public String convert(String s, int numRows) {
        String ans = "";
        for(int i = 0; i < numRows; i++){
             for(int j = i; j < s.length(); j += 2 * (numRows - 1)){
                 ans = ans + s.charAt(j);
                 if(i != 0 && i != numRows - 1 && (j + 2 * (numRows - i - 1) < s.length())){
                     ans = ans + s.charAt(j + 2 * (numRows - i - 1));
                 }
             }
             
        }
        return ans;
    }
}