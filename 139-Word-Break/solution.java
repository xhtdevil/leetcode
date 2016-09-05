public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        //Time limit exceed
        // if(s.length() == 0)return true;

        // for(String str : wordDict){
        //     if(s.startsWith(str)){
        //         if(wordBreak(s.substring(str.length()), wordDict))return true;
        //     }
        // }
        // return false;
        boolean[] ans = new boolean[s.length() + 1];
        ans[0] = true;
        for(int i = 1; i < s.length() + 1; i++){
            ans[i] = false;
            for(String str : wordDict){
                if(str.length() <= i && ans[i - str.length()] && s.substring(i - str.length(), i).equals(str)){
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[s.length()];
    }
}