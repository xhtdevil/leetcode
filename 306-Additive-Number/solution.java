import java.math.BigInteger;
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if(n < 3)return false;
        for(int i = 1; i < n - i; i++){
             if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger s1 = new BigInteger(num.substring(0, i));
            for(int j = 1; n - i - j >= Math.max(i, j); j++){
                 if (num.charAt(i) == '0' && j > 1) break;
                BigInteger s2 = new BigInteger(num.substring(i, i + j));
                if(isValid(num, s1, s2, i + j))return true;
            }
        }
        return false;
    }
    
    private boolean isValid(String num, BigInteger s1, BigInteger s2, int startIndex){
        if(startIndex >= num.length())return true;
        s2 = s2.add(s1);
        s1 = s2.subtract(s1);
        return num.startsWith(s2.toString(), startIndex) && isValid(num, s1, s2, s2.toString().length() + startIndex);
    }
}