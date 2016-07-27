public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int countLast = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(count != 0)countLast = count;
                count = 0;
            }
            else count++;
        }
        if(s.length() == 0){return 0;}
        else if(count == 0)return countLast;
        return count;
    }
}