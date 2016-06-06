public class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(true){
            fast = squareAdd(squareAdd(fast));
            if(fast == 1){return true;}
            slow = squareAdd(slow);
            if(slow == fast){return false;}
        }
    }
    private int squareAdd(int n){
        int n_new = 0;
        while(n != 0){
            n_new += (n % 10) * (n % 10);
            n = n / 10;
        }
        return n_new;
    }
}