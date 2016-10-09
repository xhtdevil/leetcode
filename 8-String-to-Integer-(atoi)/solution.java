public class Solution {
    public int myAtoi(String str) {
        long ans = 0;
        boolean neg = false;
        if(str.length() == 0)return 0;
        int start = 0;
        int j = 0;
        while(str.charAt(j) == ' ') {
            j++;
        }
        if(str.charAt(j) == '-') {
            neg = true;
            j++;
        }
        else if(str.charAt(j) == '+') {
            neg = false;
            j++;
        }
        for(int i = j; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
            ans = ans * 10 + (str.charAt(i) - '0');
            if(ans > Integer.MAX_VALUE && !neg) return Integer.MAX_VALUE;
            else if(ans > Integer.MAX_VALUE && neg) return Integer.MIN_VALUE;
        }
        if(neg)return -(int)ans;
        else return (int) ans;
    }
}