public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        int revx = 0;
        int stx = x;
        while(x != 0){
            revx = revx * 10 + x % 10;
            x = x / 10;
        }
        return stx == revx; 
    }
}