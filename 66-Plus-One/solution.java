public class Solution {
    public int[] plusOne(int[] digits) {
        int ans = 0;
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] + carry > 9){ 
                digits[i] = 0;
                carry = 1;
            }
            else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        if(carry == 0)return digits;
        else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for(int i = 1; i < digits.length + 1; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        // if(!carry) digits[]
        // // ans = ans + 1;
        // int[] res;
        // if(carry) {
        //     res = new int[digits.length + 1];
        // }
        // else{
        //     res = new int[digits.length];
        // } 
        // for(int i = res.length - 1; i >= 0; i--) {
        //     res[i] = ans % 10;
        //     ans = ans / 10;
        // }
        // return res;
    }
}