public class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        while(n != 0){
            int res = n % 26;
            char c = (char)('A' + ((res + 25) % 26));
            ans = c + ans;
            n = (n - 1) / 26;
        }
        return ans;
    }
}