public class Solution {
    public String addBinary(String a, String b) {
        char digitS = '0', carry = '0';
        String answer = "";
        int al = a.length(), bl = b.length();
        for(int i = 0; i < Math.max(al, bl); i++){
            char ca, cb;
            if(i >= al){ca = '0';}else{ca = a.charAt(al - i - 1);}
            if(i >= bl){cb = '0';}else{cb = b.charAt(bl - i - 1);}
            if(ca == '1' && cb == '1' && carry == '1'){digitS = '1'; carry = '1';}
            else if(ca == '1' && cb == '1' && carry == '0' || ca == '0' && cb == '1' && carry == '1' || ca == '1' && cb == '0' && carry == '1'){digitS = '0'; carry = '1';}
             else if(ca == '1' && cb == '0' && carry == '0' || ca == '0' && cb == '0' && carry == '1' || ca == '0' && cb == '1' && carry == '0'){digitS = '1'; carry = '0';}
             else{digitS = '0'; carry = '0';}
             answer = digitS + answer;
        }
        if(carry == '1'){answer = '1' + answer;}
        return answer;
    }
}