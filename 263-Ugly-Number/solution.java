public class Solution {
    public boolean isUgly(int num) {
        if(num == 1){return true;}
        while( num % 5 == 0){
            num = num / 5;
        }
        while( num % 2 == 0){
            num = num / 2;
        }
        while( num % 3 == 0){
            num = num / 3;
        }
        if(num == 1){return true;}else{
            return false;
        }
    }
}