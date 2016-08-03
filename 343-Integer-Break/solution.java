public class Solution {
    public int integerBreak(int n) {
        if(n == 1)return 0;
        if(n == 2)return 1;
        if(n == 3)return 2;
        if(n == 4)return 4;
        if(n == 5)return 6;
        if(n == 6)return 9;
        if(n == 7)return 12;
        if(n == 8)return 18;
        if(n == 9)return 27;
        if(n == 10)return 36;
        return  3 * integerBreak(n -3);
    }
}