public class Solution {
    public String multiply(String num1, String num2) {
       
        if(num1.length() == 1 && num2.length() == 1){
            return ((num1.charAt(0) - '0') * (num2.charAt(0) - '0') + "");
        }
        else if(num1.length() == 0 || num2.length() == 0)return "";
        else{
            int n1 = num1.length(), n2 = num2.length();
            String num1h = num1.substring(0, n1 / 2);
            String num1l = num1.substring(n1 / 2);
            String num2h = num2.substring(0, n2 / 2);
            String num2l = num2.substring(n2 / 2);
            String a = multiply(num1l, num2l);
            String b = multiply(num1h, num2h);
            String c = multiply(num1l, num2h);
            String d = multiply(num1h, num2l);
            while(a.length() < (n1 - n1 / 2 + n2 - n2 / 2)){
                a = '0' + a;
            }
            String ans = addTo(b + a, c,  n2 - n2 / 2);
            ans = addTo(ans, d, n1 - n1 / 2);
            int i = 0;
            while(ans.charAt(i) == '0' && ans.length() - i > 1){
                i++;
            }
            ans = ans.substring(i);
            return ans;
        }
    }
    
    private String addTo(String num1, String num2, int digit){
        int d = 0, c = 0, num2d, num1d;
        String ans = num1.substring(num1.length() - digit);
        for(int i = 0; i < num1.length() - digit || i < num2.length(); i++){
            if(i >= num2.length()){
                num2d = 0;
            }
            else {
                num2d = num2.charAt(num2.length() - 1 - i) - '0';
            }
            if(i >= num1.length() - digit){
                num1d = 0;
            }
            else {
                num1d = num1.charAt(num1.length() - 1 - (i + digit)) - '0';
            }
            d = (num2d + num1d + c) % 10;
            c = (num2d + num1d + c) / 10;
            ans = d + ans;
        }
        if(c == 1)ans = '1' + ans;
        return ans;
    }
}