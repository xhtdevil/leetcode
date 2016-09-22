public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)return s;
        int max = 0;
        String ans  = "";
        for(int i = 0; i < s.length(); i++){
            String str1 = extendP(s, i, i + 1);
            if(str1.length() > max){
                ans = str1;
                max = str1.length();
            }
            String str2 = extendP(s, i, i);
            if(str2.length() > max){
                ans = str2;
                max = str2.length();
            }
        }
        return ans;
    }
    
    private String extendP(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}