public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> preans = new ArrayList<String>();
        if(digits.length() == 0)return preans;
        String[] c = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        preans.add("");
        for(int i = 0; i < digits.length(); i++){
            String temp = c[digits.charAt(i) - '0'];
            int s = preans.size();
            List<String> ans = new ArrayList<String>();
            for(int j = 0; j < temp.length(); j++){
                for(int m = 0; m < s; m++){
                    ans.add(preans.get(m) + temp.charAt(j));
                }
            }
            preans = ans;
        }
        return preans;
    }
}