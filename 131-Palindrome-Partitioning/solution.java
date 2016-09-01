public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        res = helper(s, s.length());
        return res;
    }
    
    private List<List<String>> helper(String s, int part){
        List<List<String>> res = new ArrayList<List<String>>();
        if(part == 0){
            res.add(new ArrayList<String>());
            return res;
        }
        for(int i = 0; i < part; i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i, part);
            if(isPalindrome(s2)){
                List<String> list = new ArrayList<String>();
                List<List<String>> lastRes = helper(s1, i);
                for(int j = 0; j < lastRes.size(); j++){
                    lastRes.get(j).add(s2);
                }
                res.addAll(lastRes);
            }
            
        }
        return res;
    }
    
    private boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1)return true;
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1))return false;
        }
        return true;
    }
}