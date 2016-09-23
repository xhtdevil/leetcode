public class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     if(s.length() <= 1)return s.length();
    //     int i = 0, j = 0, l = 0, max = 0;
    //     while(i < s.length() && j < s.length()){
    //         int rep = s.indexOf(s.charAt(j) + "", i);
    //         if(rep == j){
    //             l++;
    //             j++;
    //         } 
    //         else {
    //             i = rep + 1;
    //             j++;
    //             l = j - i;
    //         }
    //         if(max < l)max = l;
    //     }
    //     return max;
    // }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}