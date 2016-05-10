public class Solution {
    public int addDigits(int num) {
        int newNum = 0;
        while(num / 10 != 0){
            while(num != 0){
                newNum += num % 10;
                num = num / 10;
            }
            num = newNum;
        }
        return num;
    }
}