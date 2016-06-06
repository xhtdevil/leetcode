public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n>0 && Math.pow(3,Math.round(Math.log10(n)/Math.log10(3))) == n){
            return true;
        }
        else{
            return false;
        }
    }
}