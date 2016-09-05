public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0)return true;
        boolean ans = false;
        for(String str : wordDict){
            if(s.startsWith(str)){
                ans = ans || wordBreak(s.substring(str.length()), wordDict);
            }
        }
        return ans;
    }
}