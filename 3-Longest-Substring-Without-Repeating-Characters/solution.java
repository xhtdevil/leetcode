public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)return s.length();
        int i = 0, j = 0, l = 0, max = 0;
        while(i < s.length() && j < s.length()){
            int rep = s.indexOf(s.charAt(j) + "", i);
            if(rep == j){
                l++;
                j++;
            } 
            else {
                i = rep + 1;
                j++;
                l = j - i;
            }
            if(max < l)max = l;
        }
        return max;
    }
}